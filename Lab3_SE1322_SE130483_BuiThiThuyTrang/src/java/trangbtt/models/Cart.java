/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.models;

import java.io.Serializable;
import java.util.HashMap;
import trangbtt.dtos.CartDTO;

/**
 *
 * @author trang
 */
public class Cart implements Serializable {

    private String customerName;
    private HashMap<String, CartDTO> cart;
    private float discount = 1;

    public Cart(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public void addToCart(CartDTO dto) throws Exception {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getId())) {
            if (this.cart.get(dto.getId()).getQuantity() - 1 > this.cart.get(dto.getId()).getQuantityCart()) {
                int quantity = this.cart.get(dto.getId()).getQuantityCart() + dto.getQuantityCart();
                dto.setQuantityCart(quantity);
            } else {
                dto.setQuantityCart(this.cart.get(dto.getId()).getQuantity());
            }
        }
        this.cart.put(dto.getId(), dto);
    }

    public void removeCart(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            if (this.cart.isEmpty()) {
                this.cart = null;
            }
        }
    }

    public void updateCart(String id, int quantity) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setQuantityCart(quantity);
        }
    }

    public int getTotal() throws Exception {
        int result = 0;
        for (CartDTO dto : this.cart.values()) {
            result += (dto.getPrice() * dto.getQuantityCart() *  discount);
        }
        return result;
    }

    public void setDiscount(float discount) {
        this.discount = 1- discount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, CartDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, CartDTO> cart) {
        this.cart = cart;
    }
}
