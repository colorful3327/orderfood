package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Order
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Order {
    @TableId(value = "orderno", type = IdType.AUTO)
    private Integer orderno;
    private String ordertime;
    private Integer empno;
    private String empnos;
    private String orderfoodtype;
    private Integer foodamount;
    private Double totalmoney;
    private Integer status;
    private String note;

    public Order() {
    }

    public Order(Integer orderno, String ordertime, Integer empno, String empnos, String orderfoodtype, Integer foodamount, Double totalmoney, Integer status, String note) {
        this.orderno = orderno;
        this.ordertime = ordertime;
        this.empno = empno;
        this.empnos = empnos;
        this.orderfoodtype = orderfoodtype;
        this.foodamount = foodamount;
        this.totalmoney = totalmoney;
        this.status = status;
        this.note = note;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpnos() {
        return empnos;
    }

    public void setEmpnos(String empnos) {
        this.empnos = empnos;
    }

    public String getOrderfoodtype() {
        return orderfoodtype;
    }

    public void setOrderfoodtype(String orderfoodtype) {
        this.orderfoodtype = orderfoodtype;
    }

    public Integer getFoodamount() {
        return foodamount;
    }

    public void setFoodamount(Integer foodamount) {
        this.foodamount = foodamount;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderno=" + orderno +
            ", ordertime='" + ordertime + '\'' +
            ", empno=" + empno +
            ", empnos='" + empnos + '\'' +
            ", orderfoodtype='" + orderfoodtype + '\'' +
            ", foodamount=" + foodamount +
            ", totalmoney=" + totalmoney +
            ", status=" + status +
            ", note='" + note + '\'' +
            '}';
    }
}
