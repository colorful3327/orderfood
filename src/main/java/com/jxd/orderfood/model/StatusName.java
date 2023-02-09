package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName StatusName
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/5
 * @Version 1.0
 */
public class StatusName {
    @TableId(value = "status", type = IdType.AUTO)
    private Integer status;

    private String sname;

    public StatusName() {
    }

    public StatusName(Integer status, String sname) {
        this.status = status;
        this.sname = sname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "StatusName{" +
            "status=" + status +
            ", sname='" + sname + '\'' +
            '}';
    }
}
