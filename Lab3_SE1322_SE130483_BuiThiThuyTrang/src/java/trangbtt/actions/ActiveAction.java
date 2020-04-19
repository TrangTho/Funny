/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.AccountDAO;
import trangbtt.dtos.AccountDTO;

/**
 *
 * @author trang
 */
public class ActiveAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private AccountDTO dto = null;
    private String email, code;

    public AccountDTO getDto() {
        return dto;
    }

    public void setDto(AccountDTO dto) {
        this.dto = dto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ActiveAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        AccountDAO dao = new AccountDAO();
        HttpServletRequest request = ServletActionContext.getRequest();

        if (dao.activeAccount(email, code)) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Insert fail");
        }

        return url;
    }

}
