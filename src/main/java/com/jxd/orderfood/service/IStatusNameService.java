package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.model.StatusName;

import java.util.List;

public interface IStatusNameService extends IService<StatusName> {
    List<StatusName> getStatusNameList();
}
