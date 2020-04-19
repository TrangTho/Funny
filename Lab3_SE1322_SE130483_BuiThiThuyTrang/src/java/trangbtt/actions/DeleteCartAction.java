/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import trangbtt.models.Cart;

/**
 *
 * @author trang
 */
public class DeleteCartAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeleteCartAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        Cart shoppingCart = (Cart) session.get("CART");
        shoppingCart.removeCart(id);
        url = SUCCESS;
        return url;

    }

}
