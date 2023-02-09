package com.jxd.orderfood.controller;

import com.jxd.orderfood.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/30
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     * 获取订餐记录
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return orderService.getAllOrderList(map);
    }

    /**
     * 保存/提交订单申请
     * @param infoMap
     * @return
     */
    @RequestMapping("/addOrderRecord")
    @Transactional  // 事务
    public String addOrderRecord(@RequestBody Map<String, Object> infoMap) {
        List<Map<String, String>> listFoods = (List<Map<String, String>>) infoMap.get("orderfoodinfo");
        List<String> listEmpnos = (List<String>) infoMap.get("empnos");
        // String orderno = (String)infoMap.get("orderno");

        if ("".equals(infoMap.get("orderno"))) {
            // 插入
            boolean isSuccessOrderAdd =
                orderService.addOrder(infoMap);
            // List<Map<String, String>> listFoods = (List<Map<String, String>>) infoMap.get("orderfoodinfo");
            boolean isSuccessOrderFoodInfoAdd =
                orderService.addOrderFoodInfo(infoMap, listFoods);
            // List<String> listEmpnos = (List<String>) infoMap.get("empnos");
            boolean isSuccessOrderEmpAdd =
                orderService.addOrderEmp(infoMap, listEmpnos);
            return isSuccessOrderAdd && isSuccessOrderFoodInfoAdd && isSuccessOrderEmpAdd ?
                (String)infoMap.get("orderno"): "fail";
        } else {
            // 更新
            boolean isSuccessOrderUpd =
                orderService.updOrder(infoMap);
            boolean isSuccessOrderFoodInfoDel =
                orderService.delOrderFoodInfo((Integer) infoMap.get("orderno"));
            boolean isSuccessOrderFoodInfoAdd =
                orderService.addOrderFoodInfo(infoMap, listFoods);
            boolean isSuccessOrderEmpDel =
                orderService.delOrderEmp((Integer) infoMap.get("orderno"));
            boolean isSuccessOrderEmpAdd =
                orderService.addOrderEmp(infoMap, listEmpnos);
            // 记住这个 Integer.toString()
            return isSuccessOrderUpd && isSuccessOrderFoodInfoDel && isSuccessOrderFoodInfoAdd && isSuccessOrderEmpDel && isSuccessOrderEmpAdd  ?
                Integer.toString((Integer) infoMap.get("orderno")): "fail";
        }
    }

    /**
     * 获取不能订餐的一堆员工的编号
     * @param map
     * @return
     */
    @RequestMapping("/getEmpnosCannotBook")
    public List<String> getEmpnosCannotBook(@RequestBody Map<String, String> map) {
        return orderService.getEmpnosCannotBook(map);
    }

    @RequestMapping("/delOrderRecords")
    @Transactional  // 事务
    public String delOrderRecords(@RequestBody List<Integer> orders){
        // 关系表 - 餐品信息表 - 订单表
        boolean isSuccessDelOrderEmps = orderService.delOrderEmpByNos(orders);
        boolean isSuccessDelOrderFoodInfos = orderService.delOrderFoodInfoByNos(orders);
        boolean isSuccessDelOrders = orderService.delOrderByNos(orders);
        return isSuccessDelOrderEmps && isSuccessDelOrderFoodInfos && isSuccessDelOrders ?
            "success" : "fail";
    }

    @RequestMapping("/listForManage")
    public Map<String,Object> listForManage(@RequestBody Map<String,String> map){
        return orderService.getOrderListForManage(map);
    }

    /**
     *
     * @param updInfo
     * @return
     */
    @RequestMapping("/managerUpdOrders")
    public String managerUpdOrders(@RequestBody Map<String, Object> updInfo) {
        List<Integer> ordernos = (List<Integer>) updInfo.get("ordernos");
        boolean isSuccess = orderService.updOrderByManager(updInfo, ordernos);
        return isSuccess ? "success": "fail";
    }

    /**
     * 这天这顿饭餐品信息汇总
     * @param queryMap
     * @return
     */
    @RequestMapping("/listStatisticFoodInfo")
    public List<Map<String, Object>> listStatisticFoodInfo(@RequestBody Map<String, Object> queryMap) {
        // List<Integer> statusList = (List<Integer>) queryMap.get("statuslist");
        // Map<String, String> map = new HashMap<>();
        // map.put("datestart", queryMap.get("datestart"));
        // map.put("dateend", queryMap.get("dateend"));
        // map.put("orderfoodtype", queryMap.get("orderfoodtype"));
        // map.put("deptno", queryMap.get("deptno"));
        // map.put("status", queryMap.get("status"));
        List<String> statusList = (List<String>) queryMap.get("statuslist");
        return orderService.getStatisticFoodInfo(queryMap
            , statusList
        );
    }

    /**
     * 订单数量
     * @param queryMap 什么条件啊
     * @return 几
     */
    @RequestMapping("/getCountByStatus")
    public Integer getCountByStatus(@RequestBody Map<String, Object> queryMap) {
        List<String> statusList = (List<String>) queryMap.get("statuslist");
        return orderService.getCountByStatus(queryMap
            , statusList
        );
    }

    @RequestMapping("/getOrderFoodList")
    public List<Map<String, Object>> getOrderFoodList(String orderno) {
        return orderService.getOrderFood(orderno);
    }
}
