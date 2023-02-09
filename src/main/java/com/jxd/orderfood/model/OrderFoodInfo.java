package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName OrderFoodInfo
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class OrderFoodInfo {
    @TableId(value = "orderno", type = IdType.AUTO)
    private Integer orderno;
    private Integer foodno;
    private Integer foodamount;
    private Double price;
    private String notes;

    public OrderFoodInfo() {
    }

    public OrderFoodInfo(Integer orderno, Integer foodno, Integer foodamount, Double price, String notes) {
        this.orderno = orderno;
        this.foodno = foodno;
        this.foodamount = foodamount;
        this.price = price;
        this.notes = notes;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getFoodno() {
        return foodno;
    }

    public void setFoodno(Integer foodno) {
        this.foodno = foodno;
    }

    public Integer getFoodamount() {
        return foodamount;
    }

    public void setFoodamount(Integer foodamount) {
        this.foodamount = foodamount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "OrderFoodInfo{" +
            "orderno=" + orderno +
            ", foodno=" + foodno +
            ", foodamount=" + foodamount +
            ", price=" + price +
            ", notes='" + notes + '\'' +
            '}';
    }
}
