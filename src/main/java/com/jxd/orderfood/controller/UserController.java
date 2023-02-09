package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/30
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUname(), user.getPassword());
    }

    @RequestMapping("/changePwd")
    public String login(@RequestBody Map<String, String> changePwd) {
        // User user = new User();
        // user.setUname(changePwd.get("uname"));
        // user.setPassword(changePwd.get("password"));
        if (userService.login(changePwd.get("uname"), changePwd.get("password")) == null) {
            return "error";
        } else {
            boolean isSuccessUpdPwd = userService.updPwd(changePwd.get("uname"), changePwd.get("newpwd"));
            return isSuccessUpdPwd? "success": "fail";
        }
    }

    @RequestMapping("/resetPwd")
    public String resetPwd(@RequestBody List<String> enames) {
        return userService.updPwdReset(enames)? "success": "fail";
    }

}
