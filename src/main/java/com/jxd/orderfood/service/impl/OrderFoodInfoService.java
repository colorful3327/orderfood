package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.OrderFoodInfoMapper;
import com.jxd.orderfood.dao.OrderMapper;
import com.jxd.orderfood.model.Order;
import com.jxd.orderfood.model.OrderFoodInfo;
import com.jxd.orderfood.service.IOrderFoodInfoService;
import com.jxd.orderfood.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderFoodInfoService
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class OrderFoodInfoService extends ServiceImpl<OrderFoodInfoMapper, OrderFoodInfo> implements IOrderFoodInfoService {
}
