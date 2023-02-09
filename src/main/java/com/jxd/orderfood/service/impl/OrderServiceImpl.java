package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.OrderAndEmpMapper;
import com.jxd.orderfood.dao.OrderFoodInfoMapper;
import com.jxd.orderfood.dao.OrderMapper;
import com.jxd.orderfood.model.Order;
import com.jxd.orderfood.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/30
 * @Version 1.0
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderFoodInfoMapper orderFoodInfoMapper;

    @Autowired
    private OrderAndEmpMapper orderAndEmpMapper;

    @Override
    public Map<String, Object> getAllOrderList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        // String ename = queryMap.get("uname");
        // String orderfoodtype = queryMap.get("orderfoodtype");
        // String status = queryMap.get("status");
        // int statu = 0;
        // if(!"".equals(status)){
        //     statu = Integer.parseInt(status);
        // }

        // String deptnos = queryMap.get("deptno");
        // int deptno = 0;
        // if(!"".equals(deptnos)){
        //     deptno = Integer.parseInt(deptnos);
        // }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Order> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            // IPage<Order> pageResult = orderMapper.selectAllOrderList(pages, ename, orderfoodtype, statu);
            IPage<Order> pageResult = orderMapper.selectAllOrderList(pages, queryMap);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    @Override
    public boolean addOrder(Map<String, Object> map) {
        return orderMapper.insertOrder(map);
    }

    @Override
    public boolean updOrder(Map<String, Object> map) {
        return orderMapper.updateOrder(map);
    }

    @Override
    public boolean addOrderFoodInfo(Map<String, Object> map, List<Map<String, String>> list) {
        return orderFoodInfoMapper.insertOrderFoodInfo(map, list);
    }

    @Override
    public boolean addOrderEmp(Map<String, Object> map, List<String> list) {
        return orderAndEmpMapper.insertOrderEmp(map, list);
    }

    @Override
    public boolean delOrderFoodInfo(Integer orderno) {
        return orderFoodInfoMapper.deleteOrderFoodInfo(orderno);
    }

    @Override
    public boolean delOrderEmp(Integer orderno) {
        return orderAndEmpMapper.deleteOrderEmp(orderno);
    }

    @Override
    public List<String> getEmpnosCannotBook(Map<String, String> map) {
        return orderAndEmpMapper.selectEmpnosCannotBook(map);
    }

    @Override
    public boolean delOrderByNos(List<Integer> ordernos) {
        return orderMapper.deleteOrderByNos(ordernos);
    }

    @Override
    public boolean delOrderFoodInfoByNos(List<Integer> ordernos) {
        return orderFoodInfoMapper.deleteOrderFoodInfoByNos(ordernos);
    }

    @Override
    public boolean delOrderEmpByNos(List<Integer> ordernos) {
        return orderAndEmpMapper.deleteOrderEmpByNos(ordernos);
    }

    @Override
    public Map<String, Object> getOrderListForManage(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Order> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Order> pageResult = orderMapper.selectOrderListForManage(pages, queryMap);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    @Override
    public boolean updOrderByManager(Map<String, Object> map, List<Integer> list) {
        return orderMapper.updateOrderByManager(map, list);
    }

    @Override
    public List<Map<String, Object>> getStatisticFoodInfo(Map<String, Object> queryMap
        , List<String> statusList
    ) {
        return orderMapper.selectStatisticFoodInfo(queryMap
            , statusList
        );
    }

    @Override
    public Integer getCountByStatus(Map<String, Object> queryMap
        , List<String> statusList
    ) {
        return orderMapper.selectCountByStatus(queryMap
            , statusList
        );
    }

    @Override
    public List<Map<String, Object>> getOrderFood(String orderno) {
        return orderMapper.selectOrderFood(orderno);
    }
}
