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
import trangbtt.daos.FeedbackDAO;
import trangbtt.dtos.CarDTO;
import trangbtt.dtos.FeedbackDTO;

/**
 *
 * @author trang
 */
public class ListCarAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private List<CarDTO> result = null;
    private String name, color, year, status, cate;
    private int id, price, quantity;
    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public List<CarDTO> getResult() {
        return result;
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

    public ListCarAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        CarDAO dao = new CarDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        result = dao.loadListCar();
        
       
        FeedbackDAO daoF = new FeedbackDAO();
        List<FeedbackDTO> resultFeedback = daoF.loadFeedback();
        CarDTO dto = new CarDTO();
        if (result != null) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Load fail");
        }

        return url;
    }

}
