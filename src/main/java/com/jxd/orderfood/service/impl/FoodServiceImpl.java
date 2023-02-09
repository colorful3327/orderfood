package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.FoodMapper;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FoodServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodList() {
        return foodMapper.selectFoodList();
    }

    @Override
    public Map<String, Object> getFoodsListByPage(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Food> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Food> pageResult = foodMapper.selectFoodsListByPage(pages, queryMap);
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
    public boolean addFood(Map<String, String> foodForm) {
        return foodMapper.insertFood(foodForm);
    }

    @Override
    public boolean updFood(Map<String, String> foodForm) {
        return foodMapper.updateFood(foodForm);
    }

    @Override
    public boolean delFoods(List<Integer> foodnos) {
        return foodMapper.deleteFoods(foodnos);
    }

    @Override
    public boolean updFoodPriceToDoDelete(List<Integer> foodnos) {
        return foodMapper.updateFoodPriceToDoDelete(foodnos);
    }

    @Override
    public String getFoodnoByFname(String fname) {
        return foodMapper.selectFoodNoByFname(fname);
    }
}
