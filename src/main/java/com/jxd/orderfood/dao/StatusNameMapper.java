package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.orderfood.model.StatusName;

import java.util.List;

public interface StatusNameMapper extends BaseMapper<StatusName> {
    List<StatusName> selectStatusNameList();
}
