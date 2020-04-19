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
import trangbtt.dbs.SendingEmail;
import trangbtt.dtos.AccountDTO;

/**
 *
 * @author trang
 */
public class AccountDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public AccountDAO() {
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

    public String checkLogin(String userId, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Role, Name From Account Where Email = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, userId);
            pre.setString(2, password);
            rs = pre.executeQuery();
            if (rs.next()) {
                role = rs.getString("Name");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean insert(AccountDTO dto, String code) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Account(Email, password, Name, Phone, Address, Role, Status, Code) VALUES (?,?,?,?,?,'user','New',?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getEmail());
            pre.setString(2, dto.getPassword());
            pre.setString(3, dto.getName());
            pre.setString(4, dto.getPhone());
            pre.setString(5, dto.getAddress());
            pre.setString(6, code);
            int result = pre.executeUpdate();
            if (result != 0) {
                SendingEmail se = new SendingEmail(dto.getEmail(), code);
                se.senMail();
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean activeAccount(String email, String code) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Account set status='Active' where email = ? and Code = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, code);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
