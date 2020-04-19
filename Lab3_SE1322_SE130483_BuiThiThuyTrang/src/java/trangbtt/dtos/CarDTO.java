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
public class CarDTO implements Serializable {

    private String name, color, year, status, cate;
    private int id, price, quantity, realQuantity;
    private float rating;

    public CarDTO() {
    }

    public CarDTO(String name, String color, String year, String status, String cate, int id, int price, int quantity, float rating, int realQuantity) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.status = status;
        this.cate = cate;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.realQuantity = realQuantity;
    }

    public CarDTO(String name, String color, String year, String status, String cate, int id, int price, int quantity, float rating) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.status = status;
        this.cate = cate;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }

    public int getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(int realQuantity) {
        this.realQuantity = realQuantity;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
    
    public void checkQuantity(){
        if(this.realQuantity == 0){
            this.realQuantity = this.quantity;
        }
    }

}
