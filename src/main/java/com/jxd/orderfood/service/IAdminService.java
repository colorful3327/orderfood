package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Admin;

public interface IAdminService extends IService<Admin> {
    String getAdminPwd(Integer adminid);
}
