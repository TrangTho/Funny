/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trang
 */
public class LogoutAction {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public LogoutAction() {
    }

    public String execute() throws Exception {

        String url = FAIL;
        Map session = ActionContext.getContext().getSession();
        if (session != null) {
            session.remove("NAME");
            url = SUCCESS;
        }
        return url;
    }

}
