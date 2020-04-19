/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CarDAO;
import trangbtt.dtos.CarDTO;

/**
 *
 * @author trang
 */
public class SearchByNameAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private List<CarDTO> resultSearchName = null;
    private String searchName, name, color, year, status, cate;
    private int id, price, quantity, quantityCar;
    private String rentalDate, returnDate;

    public List<CarDTO> getResultSearchName() {
        return resultSearchName;
    }

    public int getQuantityCar() {
        return quantityCar;
    }

    public void setQuantityCar(int quantityCar) {
        this.quantityCar = quantityCar;
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

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
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

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
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

    public SearchByNameAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        CarDAO dao = new CarDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        resultSearchName = dao.searchByName(searchName, rentalDate, returnDate, quantityCar);

        if (resultSearchName != null) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Insert fail");
        }

        return url;
    }

}
