package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.AdminMapper;
import com.jxd.orderfood.model.Admin;
import com.jxd.orderfood.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/29
 * @Version 1.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String getAdminPwd(Integer adminid) {
        return adminMapper.selectAdminPwd(adminid);
    }
}
