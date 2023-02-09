package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.model.StatusName;
import com.jxd.orderfood.service.IFoodService;
import com.jxd.orderfood.service.IStatusNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName StatusNameController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/6
 * @Version 1.0
 */
@RestController
public class StatusNameController {
    @Autowired
    private IStatusNameService statusNameService;

    @RequestMapping("/statusnameList")
    public List<StatusName> getFoodList() {
        List<StatusName> list = statusNameService.getStatusNameList();
        return list;
    }
}
