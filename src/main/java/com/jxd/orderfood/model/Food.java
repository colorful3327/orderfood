package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Food
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Food {
    @TableId(value = "foodno", type = IdType.AUTO)
    private Integer foodno;
    private String fname;
    private Double price;

    public Food() {
    }

    public Food(Integer foodno, String fname, Double price) {
        this.foodno = foodno;
        this.fname = fname;
        this.price = price;
    }

    public Integer getFoodno() {
        return foodno;
    }

    public void setFoodno(Integer foodno) {
        this.foodno = foodno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
            "foodno=" + foodno +
            ", fname='" + fname + '\'' +
            ", price=" + price +
            '}';
    }
}
