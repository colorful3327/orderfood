package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.OrderAndEmpMapper;
import com.jxd.orderfood.model.OrderAndEmp;
import com.jxd.orderfood.service.IOrderAndEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderAndEmpServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class OrderAndEmpServiceImpl extends ServiceImpl<OrderAndEmpMapper, OrderAndEmp> implements IOrderAndEmpService {
    @Autowired
    private OrderAndEmpMapper orderAndEmpMapper;


}
