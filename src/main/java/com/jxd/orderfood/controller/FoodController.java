package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName FoodController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class FoodController {
    @Autowired
    private IFoodService foodService;

    @RequestMapping("/foodList")
    public List<Food> getFoodList() {
        List<Food> list = foodService.getFoodList();
        return list;
    }

    @RequestMapping("/foodsListByPage")
    public Map<String, Object> foodsListByPage(@RequestBody Map<String,String> map) {
        return foodService.getFoodsListByPage(map);
    }

    @RequestMapping("/addFood")
    public String addFood(@RequestBody Map<String, String> foodForm) {
        return foodService.addFood(foodForm)? "success": "fail";
    }

    @RequestMapping("/updateFood")
    public String updateFood(@RequestBody Map<String, String> foodForm) {
        return foodService.updFood(foodForm)? "success": "fail";
    }

    @RequestMapping("/delFoods")
    public String delFoods(@RequestBody List<Integer> foodnos) {
        return foodService.updFoodPriceToDoDelete(foodnos)? "success": "fail";
        // 重来，和员工一样，不真的删除它
        // return foodService.delFoods(foodnos)? "success": "fail";
    }

    @RequestMapping("/checkSameNameFood")
    public String checkSameNameFood(String fname){
        return foodService.getFoodnoByFname(fname);
    }

}
