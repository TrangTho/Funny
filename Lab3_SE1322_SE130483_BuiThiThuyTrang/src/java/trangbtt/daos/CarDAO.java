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

/**
 *
 * @author trang
 */
public class CarDAO implements Serializable {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public CarDAO() {
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

    public List<CarDTO> loadListCar() throws Exception {
        List<CarDTO> result = null;
        CarDTO dto = null;
        int id = 0, price = 0, quantity = 0;
        String name = null, color = null, year = null, cate = null;
        float rating = 0;
        try {
            String sql = "Select c.ID, c.Name, c.Color, YEAR(c.Year) as 'Years', c.Price, c.Quantity, ct.Name as 'Category Car', "
                    + "(select avg(rating) from Feedback where CarID = c.ID) as 'rating' From Car c, Category ct where c.CateID = ct.ID and c.Quantity > 0";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                color = rs.getString("Color");
                year = rs.getString("Years");
                price = rs.getInt("Price");
                quantity = rs.getInt("Quantity");
                cate = rs.getString("Category Car");
                rating = rs.getFloat("rating");
                dto = new CarDTO(name, color, year, cate, cate, id, price, quantity, rating);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<CarDTO> searchByName(String searchName, String rentalDate, String returnDate, int quantityCar) throws Exception {
        List<CarDTO> result = null;
        CarDTO dto = null;
        int id = 0, price = 0, quantity = 0;
        String name = null, color = null, year = null, cate = null;
        float rating = 0;
        int realQuantity = 0;
        try {
            String sql = "select c.ID, c.Name, c.Color, YEAR(c.Year) as 'Years', c.Price, c.Quantity, ct.Name as 'Category Car', "
                    + "(select avg(rating) from Feedback where CarID = c.ID) as 'rating', c.Quantity - (select sum(Quantity) "
                    + "from Order_Detail where OrderID in (select ID from [Order] "
                    + "where RentalDate between ? and ? or ReturnDate between ? and ?) and CarID = c.ID) as 'Real Quantity' From Car c, Category ct "
                    + "where  c.CateID = ct.ID and c.Name like ? and c.Quantity > ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, rentalDate);
            pre.setString(2, returnDate);
            pre.setString(3, rentalDate);
            pre.setString(4, returnDate);
            pre.setString(5, "%" + searchName + "%");
            pre.setInt(6, quantityCar);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                color = rs.getString("Color");
                year = rs.getString("Years");
                price = rs.getInt("Price");
                quantity = rs.getInt("Quantity");
                cate = rs.getString("Category Car");
                rating = rs.getFloat("rating");
                realQuantity = rs.getInt("Real Quantity");
                dto = new CarDTO(name, color, year, cate, cate, id, price, quantity, rating, realQuantity);
                dto.checkQuantity();
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<CarDTO> searchByCate(String searchCate, String rentalDate1, String returnDate1, int quantityCar1) throws Exception {
        List<CarDTO> result = null;
        CarDTO dto = null;
        int id = 0, price = 0, quantity = 0;
        String name = null, color = null, year = null, cate = null;
        float rating = 0;
        int realQuantity = 0;
        try {
            String sql = "select c.ID, c.Name, c.Color, YEAR(c.Year) as 'Years', c.Price, c.Quantity, ct.Name as 'Category Car', "
                    + "(select avg(rating) from Feedback where CarID = c.ID) as 'rating', c.Quantity - (select sum(Quantity) "
                    + "from Order_Detail where OrderID in (select ID from [Order] "
                    + "where RentalDate between ? and ? or ReturnDate between ? and ?) and CarID = c.ID) as 'Real Quantity' From Car c, Category ct "
                    + "where  c.CateID = ct.ID and ct.Name like ? and c.Quantity > ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, rentalDate1);
            pre.setString(2, returnDate1);
            pre.setString(3, rentalDate1);
            pre.setString(4, returnDate1);
            pre.setString(5, "%" + searchCate + "%");
            pre.setInt(6, quantityCar1);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                color = rs.getString("Color");
                year = rs.getString("Years");
                price = rs.getInt("Price");
                quantity = rs.getInt("Quantity");
                cate = rs.getString("Category Car");
                rating = rs.getFloat("rating");
                realQuantity = rs.getInt("Real Quantity");
                dto = new CarDTO(name, color, year, cate, cate, id, price, quantity, rating, realQuantity);
                dto.checkQuantity();
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateQuantityProduct(int quantity, int id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Car set Quantity = ? Where ID = ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, quantity);
            pre.setInt(2, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
