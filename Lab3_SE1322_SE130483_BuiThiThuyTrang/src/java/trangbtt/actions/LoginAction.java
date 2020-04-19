/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.AccountDAO;

/**
 *
 * @author trang
 */
public class LoginAction {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        AccountDAO dao = new AccountDAO();
        String name = dao.checkLogin(email, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (name.equals("failed")) {
            request.setAttribute("ERROR", "Role is invalid");
        } else {
            url = SUCCESS;
            Map session = ActionContext.getContext().getSession();
            session.put("NAME", name);
            session.put("EMAIL", email);
        }
        return url;
    }

}
