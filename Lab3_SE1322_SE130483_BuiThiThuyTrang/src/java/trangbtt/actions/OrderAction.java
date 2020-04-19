/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import trangbtt.dtos.CartDTO;
import trangbtt.models.Cart;

/**
 *
 * @author trang
 */
public class OrderAction {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private String id, name, cate, user;
    private int price, quantity;

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public OrderAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        Cart shoppingCart = (Cart) session.get("CART");
        if (shoppingCart == null) {
            shoppingCart = new Cart(user);
        }
        CartDTO dto = new CartDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setPrice(price);
        dto.setQuantity(quantity);
        dto.setCategory(cate);
        dto.setQuantityCart(1);

        shoppingCart.addToCart(dto);
        session.put("CART", shoppingCart);
        url = SUCCESS;

        return url;
    }

}
