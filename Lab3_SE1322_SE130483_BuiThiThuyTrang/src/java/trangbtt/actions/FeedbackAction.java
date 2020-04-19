/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CartDAO;
import trangbtt.daos.FeedbackDAO;

/**
 *
 * @author trang
 */
public class FeedbackAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String id,user;
    private int rating, carID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public FeedbackAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        FeedbackDAO dao = new FeedbackDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (dao.insertFeedback(carID, rating)) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Insert Feedback failed");

        }
        return url;
    }

}
