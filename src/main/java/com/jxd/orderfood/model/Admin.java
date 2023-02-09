package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Admin {
    @TableId(value = "adminid", type = IdType.AUTO)
    private Integer adminid;
    private String adminpwd;

    public Admin() {
    }

    public Admin(Integer adminid, String adminpwd) {
        this.adminid = adminid;
        this.adminpwd = adminpwd;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "adminid=" + adminid +
            ", adminpwd='" + adminpwd + '\'' +
            '}';
    }
}
