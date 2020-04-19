/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.dtos;

import java.util.List;

/**
 *
 * @author trang
 */
public class FoodPaging {
    private int totalPage;
    private List<FoodDTO> listFood;

    
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<FoodDTO> getListFood() {
        return listFood;
    }

    public void setListFood(List<FoodDTO> listFood) {
        this.listFood = listFood;
    }
    
    
}
