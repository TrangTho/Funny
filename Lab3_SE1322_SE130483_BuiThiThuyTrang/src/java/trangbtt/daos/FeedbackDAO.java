/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trangbtt.dbs.MyConnection;
import trangbtt.dtos.FeedbackDTO;

/**
 *
 * @author trang
 */
public class FeedbackDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public FeedbackDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pre != null) {
            pre.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean insertFeedback(int id, int rating) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into [Feedback](Rating, CarID) values(?,?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, rating);
            pre.setInt(2, id);
            
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<FeedbackDTO> loadFeedback() throws Exception {
        List<FeedbackDTO> result = null;
        FeedbackDTO dto = null;
        int id = 0, rating = 0;
        try {
            String sql = "Select Rating, CarID from Feedback";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("CarID");
                rating = rs.getInt("Rating");
                dto = new FeedbackDTO(id, rating);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
