package com.jxd.orderfood.model;

/**
 * @ClassName User
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class User {
    private String uname;
    private String password;
    private String job;

    public User() {
    }

    public User(String uname, String password, String job) {
        this.uname = uname;
        this.password = password;
        this.job = job;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
