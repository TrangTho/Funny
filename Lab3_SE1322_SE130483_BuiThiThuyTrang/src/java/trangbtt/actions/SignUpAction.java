/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.AccountDAO;
import trangbtt.dbs.SHABTT;
import trangbtt.dtos.AccountDTO;

/**
 *
 * @author trang
 */
public class SignUpAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private AccountDTO dto = null;
    private String email, name, password, confirm, phone, address;

    public AccountDTO getDto() {
        return dto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public SignUpAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        AccountDAO dao = new AccountDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (password.equals(confirm)) {
            AccountDTO dto = new AccountDTO();
            SHABTT sha = new SHABTT();
            Random random = new Random();
            random.nextInt(999999);
            String code = sha.toHexString(sha.getSHA(random.toString()));
            System.out.println(code);
            dto.setEmail(email);
            dto.setPassword(password);
            dto.setAddress(address);
            dto.setName(name);
            dto.setPhone(phone);
            dto.setCode(code);

            if (dao.insert(dto,code)) {
                url = SUCCESS;
                
            } else {
                request.setAttribute("ERROR", "Insert fail");
            }

        }
        return url;
    }

}
