/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import trangbtt.daos.DiscountDAO;
import trangbtt.models.Cart;

/**
 *
 * @author trang
 */
public class InsertCodeAction {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public InsertCodeAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        Cart shoppingCart = (Cart) session.get("CART");
        DiscountDAO dao = new DiscountDAO();
        float discount = (dao.getDiscount(code) * 0.01f);
        shoppingCart.setDiscount(discount);
        url = SUCCESS;
        return url;
    }
    
}
