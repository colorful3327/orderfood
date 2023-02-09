package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.orderfood.model.OrderAndEmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderAndEmpMapper extends BaseMapper<OrderAndEmp> {
    /**
     * 插入
     * @param map
     * @param list
     * @return
     */
    boolean insertOrderEmp(
        @Param("infoMap") Map<String, Object> map,
        @Param("list") List<String> list);

    /**
     * 删除
     * @param orderno
     * @return
     */
    boolean deleteOrderEmp(
        @Param("orderno") Integer orderno);

    List<String> selectEmpnosCannotBook(
        @Param("queryCheckSelectEmps") Map<String, String> map);

    boolean deleteOrderEmpByNos(@Param("ordernos") List<Integer> ordernos);
}
