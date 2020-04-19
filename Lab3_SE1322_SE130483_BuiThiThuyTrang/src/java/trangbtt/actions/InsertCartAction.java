/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CarDAO;
import trangbtt.daos.CartDAO;
import trangbtt.dtos.CartDTO;
import trangbtt.dtos.OrderDTO;
import trangbtt.models.Cart;

/**
 *
 * @author trang
 */
public class InsertCartAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String user, rentalDate, returnDate, code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public InsertCartAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        Cart shoppingCart = (Cart) session.get("CART");
        HttpServletRequest request = ServletActionContext.getRequest();
        if (shoppingCart != null) {
            CartDAO dao = new CartDAO();
            CarDAO daoC = new CarDAO();

            if (dao.insertOrder(user, rentalDate, returnDate)) {
                int idOrder = dao.loadIdOrder();
                for (CartDTO dto : shoppingCart.getCart().values()) {
                    if (code.length() == 0) {
                        if (dao.insertOrderDetail(idOrder, dto.getId(), dto.getQuantityCart())) {
                            int idF = Integer.parseInt(dto.getId());
                            if (!daoC.updateQuantityProduct(dto.getQuantity() - dto.getQuantityCart(), idF)) {
                            }
                        }
                    } else {
                        if (dao.insertOrderDetailandCode(idOrder, dto.getId(), dto.getQuantityCart(), code)) {
                            int idF = Integer.parseInt(dto.getId());
                            if (!daoC.updateQuantityProduct(dto.getQuantity() - dto.getQuantityCart(), idF)) {
                            }
                        }
                    }

                }
                url = SUCCESS;
                session.put("CART", null);
            } else {
                url = ERROR;
                request.setAttribute("ERROR", "Insert Cart Failed");
            }
        } else {
            url = ERROR;
            request.setAttribute("ERROR", "Cart is empty");

        }
        return url;
    }

}
