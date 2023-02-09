package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserService extends IService<User> {
    User login(String uname, String password);

    boolean updPwd(String uname, String password);

    boolean updPwdReset(List<String> enames);

    boolean addUser(Map<String, String> userForm);

    boolean delUsers(List<String> unames);

    boolean updUname(String olduname, String ename);
}
