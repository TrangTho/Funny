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
public class SearchByCategoryAction {
    
     private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private List<CarDTO> resultSearchName = null;
    private String searchCate, name, color, year, status, cate;
    private int id, price, quantity, quantityCar1;
    private String rentalDate1, returnDate1;

    public List<CarDTO> getResultSearchName() {
        return resultSearchName;
    }

    

    public String getSearchCate() {
        return searchCate;
    }

    public void setSearchCate(String searchCate) {
        this.searchCate = searchCate;
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

    public int getQuantityCar1() {
        return quantityCar1;
    }

    public void setQuantityCar1(int quantityCar1) {
        this.quantityCar1 = quantityCar1;
    }

    public String getRentalDate1() {
        return rentalDate1;
    }

    public void setRentalDate1(String rentalDate1) {
        this.rentalDate1 = rentalDate1;
    }

    public String getReturnDate1() {
        return returnDate1;
    }

    public void setReturnDate1(String returnDate1) {
        this.returnDate1 = returnDate1;
    }

    public SearchByCategoryAction() {
    }
    
    public String execute() throws Exception {
       String url = ERROR;
        CarDAO dao = new CarDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        resultSearchName = dao.searchByCate(searchCate, rentalDate1, returnDate1, quantityCar1);

        if (resultSearchName != null) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Insert fail");
        }

        return url;
    }
    
}
