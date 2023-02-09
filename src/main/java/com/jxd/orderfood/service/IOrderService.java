package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IOrderService extends IService<Order> {
    /**
     * 查询订单申请记录
     * @param map
     * @return
     */
    Map<String, Object> getAllOrderList(Map<String,String> map);

    /**
     * 提交订单
     * @param map
     * @return
     */
    boolean addOrder(Map<String, Object> map);
    boolean updOrder(Map<String, Object> map);

    boolean addOrderFoodInfo(
        Map<String, Object> map,
        List<Map<String, String>> list);

    boolean addOrderEmp(
        Map<String, Object> map,
        List<String> list);

    boolean delOrderFoodInfo(Integer orderno);

    boolean delOrderEmp(Integer orderno);

    List<String> getEmpnosCannotBook(Map<String, String> map);

    boolean delOrderByNos(@Param("ordernos") List<Integer> ordernos);

    boolean delOrderFoodInfoByNos(@Param("ordernos") List<Integer> ordernos);

    boolean delOrderEmpByNos(@Param("ordernos") List<Integer> ordernos);

    Map<String, Object> getOrderListForManage(Map<String,String> map);

    boolean updOrderByManager(
        Map<String, Object> map, List<Integer> list);

    List<Map<String, Object>> getStatisticFoodInfo(
        Map<String, Object> queryMap
        , List<String> statusList
    );

    Integer getCountByStatus(
        Map<String, Object> queryMap
        , List<String> statusList
    );

    List<Map<String, Object>> getOrderFood(String orderno);
}
