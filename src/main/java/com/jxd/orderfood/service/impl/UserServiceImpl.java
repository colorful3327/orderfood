package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.dao.UserMapper;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IEmpService;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/30
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String uanme, String password) {
        return userMapper.login(uanme, password);
    }

    @Override
    public boolean updPwd(String uname, String password) {
        return userMapper.updatePwd(uname, password);
    }

    @Override
    public boolean updPwdReset(List<String> enames) {
        return userMapper.updatePwdReset(enames);
    }

    @Override
    public boolean addUser(Map<String, String> userForm) {
        return userMapper.insertUser(userForm);
    }

    @Override
    public boolean delUsers(List<String> unames) {
        return userMapper.deleteUsers(unames);
    }

    @Override
    public boolean updUname(String olduname, String ename) {
        return userMapper.updateUname(olduname, ename);
    }
}
