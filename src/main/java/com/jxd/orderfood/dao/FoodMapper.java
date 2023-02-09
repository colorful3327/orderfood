package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FoodMapper extends BaseMapper<Food> {
    List<Food> selectFoodList();

    IPage<Food> selectFoodsListByPage(
        IPage<Food> page, @Param("queryMap") Map<String,String> map);

    boolean insertFood(@Param("foodForm") Map<String, String> foodForm);

    boolean updateFood(@Param("foodForm") Map<String, String> foodForm);

    boolean deleteFoods(@Param("foodnos") List<Integer> foodnos);

    boolean updateFoodPriceToDoDelete(@Param("foodnos") List<Integer> foodnos);

    String selectFoodNoByFname(@Param("fname") String fname);


}
