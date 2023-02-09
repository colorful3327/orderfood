package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    User login(@Param("uname") String uname, @Param("password") String password);

    boolean updatePwd(@Param("uname") String uname, @Param("password") String password);

    boolean updatePwdReset(@Param("enames") List<String> enames);

    boolean insertUser(@Param("userForm") Map<String, String> userForm);

    boolean deleteUsers(@Param("unames") List<String> unames);

    boolean updateUname(@Param("olduname") String olduname, @Param("ename") String ename);
}
