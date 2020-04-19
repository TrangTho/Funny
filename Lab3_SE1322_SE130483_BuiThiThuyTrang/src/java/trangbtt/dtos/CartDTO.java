/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.dtos;

import java.io.Serializable;

/**
 *
 * @author trang
 */
public class CartDTO implements Serializable{
    private int  quantity, price,quantityCart;
    private String id,name,category,carID;
    private String  date,code;
    private String rentalDate, returnDate,email;
    public CartDTO() {
    }

    public CartDTO(String id, String date, String rentalDate, String returnDate, String email) {
        this.id = id;
        this.date = date;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.email = email;
    }
    
    public CartDTO(int quantity, int price, String name, String date) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.date = date;
    }

    public CartDTO(int quantity, int price, String id, String name, String carID, String date,String code) {
        this.quantity = quantity;
        this.price = price;
        this.id = id;
        this.name = name;
        this.carID = carID;
        this.date = date;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   
    
    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
