package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.orderfood.model.OrderFoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderFoodInfoMapper extends BaseMapper<OrderFoodInfo> {
    /**
     * 插入订单对应餐品信息
     * @param map
     * @param list
     * @return
     */
    boolean insertOrderFoodInfo(
        @Param("infoMap") Map<String, Object> map,
        @Param("list") List<Map<String, String>> list);

    boolean deleteOrderFoodInfo(@Param("orderno") Integer orderno);

    boolean deleteOrderFoodInfoByNos(@Param("ordernos") List<Integer> ordernos);
}
