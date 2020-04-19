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
import trangbtt.dbs.MyConnection;

/**
 *
 * @author trang
 */
public class DiscountDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public DiscountDAO() {
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
    public int getDiscount(String code) throws Exception{
        int result = 0;
        String sql = "Select Discount From Discount where Code = ?";
        conn = MyConnection.getMyConnection();
        pre = conn.prepareStatement(sql);
        pre.setString(1, code);
        rs = pre.executeQuery();
        if(rs.next()){
            result = rs.getInt("Discount");
        }
        return result;
    }
}
