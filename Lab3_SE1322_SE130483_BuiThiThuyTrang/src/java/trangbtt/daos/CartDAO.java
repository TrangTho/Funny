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
import trangbtt.dtos.CarDTO;
import trangbtt.dtos.CartDTO;
import trangbtt.dtos.OrderDTO;

/**
 *
 * @author trang
 */
public class CartDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public CartDAO() {
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

    public boolean insertOrder(String userID, String rentalDate, String returnDate) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into [Order](Email,RentalDate, ReturnDate, Status) values(?,?,?,'Active')";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, userID);
            pre.setString(2, rentalDate);
            pre.setString(3, returnDate);

            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public int loadIdOrder() throws Exception {
        int id = 0;
        OrderDTO dto = null;
        try {
            String sql = "select top 1 o.ID From [Order] o order by o.DateOrder desc";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
            }

        } finally {
            closeConnection();
        }
        return id;
    }

    public boolean insertOrderDetail(int orderId, String carID, int quantity) throws Exception {
        boolean check = false;
        int idF = Integer.parseInt(carID);
        try {
            String sql = "Insert into Order_Detail(OrderID, CarID, Quantity) values(?,?,?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, orderId);
            pre.setInt(2, idF);
            pre.setInt(3, quantity);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertOrderDetailandCode(int orderId, String carID, int quantity, String code) throws Exception {
        boolean check = false;
        int idF = Integer.parseInt(carID);
        try {
            String sql = "Insert into Order_Detail(OrderID, CarID, Quantity, Code) values(?,?,?,?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, orderId);
            pre.setInt(2, idF);
            pre.setInt(3, quantity);
            pre.setString(4, code);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<CartDTO> loadHisoryOfUser(String user) throws Exception {
        List<CartDTO> result = null;
        CartDTO dto = null;
        String mail = null;
        String rentalDate = null, returnDate = null;
        String date = null;
        String id = null;
        try {
            String sql = "Select o.ID, o.Email,o.RentalDate, o.ReturnDate, o.DateOrder as Date From [Order] as o Where o.Email = ? and o.Status = 'Active' order by o.DateOrder desc";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("ID");
                mail = rs.getString("Email");
                rentalDate = rs.getString("RentalDate");
                returnDate = rs.getString("ReturnDate");
                date = rs.getString("Date");
                dto = new CartDTO(id, date, rentalDate, returnDate, mail);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<CartDTO> detailHistory(String user, String id) throws Exception {
        List<CartDTO> result = null;
        CartDTO dto = null;
        String name = null;
        int price = 0;
        int quan = 0;
        String date = null;
        String idCar = null;
        String code = null;
        try {
            String sql = "Select o.ID, c.ID as CarID, c.Name as NameF,c.Price as PriceF, ds.Discount, od.Quantity as QuantityF, o.DateOrder as Date "
                    + "From [Order] as o, Order_Detail as od , Car as c , Account as ac,Discount ds "
                    + "Where o.ID = od.OrderID and o.Email = ? and c.ID = od.CarID and o.Email = ac.Email and o.Status = 'Active' and o.ID = ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, id);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("ID");
                idCar = rs.getString("CarID");
                name = rs.getString("NameF");
                price = rs.getInt("PriceF");
                quan = rs.getInt("QuantityF");
                date = rs.getString("Date");
                code = rs.getString("Discount");
                dto = new CartDTO(quan, price, id, name, idCar, date,code);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<CartDTO> searchByNameHistory(String user, String search) throws Exception {
        List<CartDTO> result = null;
        CartDTO dto = null;
        String id = null;
        String mail = null;
        String rentalDate = null, returnDate = null;
        String date = null;
        try {
            String sql = "Select o.ID, o.Email,o.RentalDate, o.ReturnDate, o.DateOrder as Date From [Order] as o Where o.Email = ? and o.Status = 'Active' and o.id in "
                    + "(select OrderId from Order_Detail where CarId in (select Id from Car where Name like ?))";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, "%" + search + "%");
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("ID");
                mail = rs.getString("Email");
                rentalDate = rs.getString("RentalDate");
                returnDate = rs.getString("ReturnDate");
                date = rs.getString("Date");
                dto = new CartDTO(id, date, rentalDate, returnDate, mail);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<CartDTO> searchByDateHistory(String user, String search) throws Exception {
        List<CartDTO> result = null;
        CartDTO dto = null;
        String id = null;
        String mail = null;
        String rentalDate = null, returnDate = null;
        String date = null;
        try {
            String sql = "Select o.ID, o.Email,o.RentalDate, o.ReturnDate, o.DateOrder as Date From [Order] as o Where o.Email = ? and o.Status = 'Active' "
                    + "and o.id in (select OrderId from Order_Detail where DateOrder between ? and ?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, search + " 00:00:00");
            pre.setString(3, search + " 23:59:59");
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("ID");
                mail = rs.getString("Email");
                rentalDate = rs.getString("RentalDate");
                returnDate = rs.getString("ReturnDate");
                date = rs.getString("Date");
                dto = new CartDTO(id, date, rentalDate, returnDate, mail);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateHistory(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update [Order] set Status = 'Inactive' where ID = ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
