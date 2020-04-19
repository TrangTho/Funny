/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CartDAO;

/**
 *
 * @author trang
 */
public class DeleteHistoryAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String id,user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeleteHistoryAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        CartDAO dao = new CartDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (dao.updateHistory(id)) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Delete failed");

        }
        return url;
    }

}
