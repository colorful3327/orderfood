package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.FoodMapper;
import com.jxd.orderfood.dao.StatusNameMapper;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.model.StatusName;
import com.jxd.orderfood.service.IFoodService;
import com.jxd.orderfood.service.IStatusNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StatusNameServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/5
 * @Version 1.0
 */
@Service
public class StatusNameServiceImpl extends ServiceImpl<StatusNameMapper, StatusName> implements IStatusNameService {
    @Autowired
    private StatusNameMapper statusNameMapper;

    @Override
    public List<StatusName> getStatusNameList() {
        return statusNameMapper.selectStatusNameList();
    }
}
