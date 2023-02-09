package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.orderfood.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<Admin> {
    String selectAdminPwd(@Param("adminid") Integer adminid);
}
