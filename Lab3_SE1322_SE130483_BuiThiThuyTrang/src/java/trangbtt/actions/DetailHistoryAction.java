/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CartDAO;
import trangbtt.dtos.CartDTO;

/**
 *
 * @author trang
 */
public class DetailHistoryAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private List<CartDTO> resultDetail = null;
    private String user, name, price, quantity, date, id, carID, code;

    public List<CartDTO> getResultDetail() {
        return resultDetail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DetailHistoryAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        CartDAO dao = new CartDAO();
        resultDetail = dao.detailHistory(user, id);
        HttpServletRequest request = ServletActionContext.getRequest();

        if (resultDetail != null) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "History is empty");

        }
        return url;
    }

}
