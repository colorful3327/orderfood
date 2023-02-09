package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderMapper extends BaseMapper<Order> {
    // IPage<Order> selectAllOrderList(
    //     IPage<Order> page,
    //     @Param("ename") String uname,
    //     @Param("orderfoodtype") String orderfoodtype,
    //     @Param("status") int status);

    /**
     * 查询订单记录
     * @param page
     * @param map
     * @return
     */
    IPage<Order> selectAllOrderList(
        IPage<Order> page, @Param("queryMap") Map<String,String> map);

    /**
     * 插入订单信息
     * @param map
     * @return
     */
    boolean insertOrder(@Param("infoMap") Map<String, Object> map);

    /**
     * 更新订单信息
     * @param map
     * @return
     */
    boolean updateOrder(@Param("infoMap") Map<String, Object> map);

    /**
     * 批量删除通过 no
     * @param ordernos
     * @return
     */
    boolean deleteOrderByNos(@Param("ordernos") List<Integer> ordernos);

    /**
     * 审批页面专用查询
     * @param page
     * @param map
     * @return
     */
    IPage<Order> selectOrderListForManage(
        IPage<Order> page, @Param("queryMap") Map<String,String> map);

    /**
     * 审批页面更新订单信息
     * @param map
     * @param list
     * @return
     */
    boolean updateOrderByManager(
        @Param("updInfo") Map<String, Object> map,
        @Param("list") List<Integer> list);

    /**
     * 汇总当天这顿饭的某些状态码的订单[某部门]对应的各餐品数量及总价
     * @param queryMap
     // * @param statusList
     * @return
     */
    // List<Map<String, String>> selectStatisticFoodInfo(
    //     @Param("queryMap") Map<String, Object> queryMap
    //     // , @Param("statusList") List<Integer> statusList
    // );
    List<Map<String, Object>> selectStatisticFoodInfo(
        @Param("queryMap") Map<String, Object> queryMap,
        @Param("statusList") List<String> statusList);

    /**
     * 获取订单数量 - 某状态码
     * @param queryMap
     * @return
     */
    Integer selectCountByStatus(
        @Param("queryMap") Map<String, Object> queryMap
        , @Param("statusList") List<String> statusList
    );

    List<Map<String, Object>> selectOrderFood(@Param("orderno") String orderno);
}
