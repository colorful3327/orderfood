package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Emp {
    @TableId(value = "empno", type = IdType.AUTO)
    private Integer empno;
    private String ename;
    private String sex;
    private String contact;
    private Integer deptno;
    private String job;
    private String password;

    public Emp() {
    }

    public Emp(String ename, String job) {
        this.ename = ename;
        this.job = job;
    }

    public Emp(Integer empno, String ename, String sex, String contact, Integer deptno, String job, String password) {
        this.empno = empno;
        this.ename = ename;
        this.sex = sex;
        this.contact = contact;
        this.deptno = deptno;
        this.job = job;
        this.password = password;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Emp{" +
            "empno=" + empno +
            ", ename='" + ename + '\'' +
            ", sex='" + sex + '\'' +
            ", contact='" + contact + '\'' +
            ", deptno=" + deptno +
            ", job='" + job + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
