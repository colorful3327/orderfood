package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IFoodService extends IService<Food> {
    List<Food> getFoodList();

    Map<String, Object> getFoodsListByPage(Map<String,String> map);

    boolean addFood(Map<String, String> foodForm);

    boolean updFood(Map<String, String> foodForm);

    boolean delFoods(List<Integer> foodnos);

    boolean updFoodPriceToDoDelete(List<Integer> foodnos);

    String getFoodnoByFname(String fname);
}
