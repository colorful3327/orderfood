package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IDeptService;
import com.jxd.orderfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/5
 * @Version 1.0
 */
@RestController
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @RequestMapping("/deptList")
    public List<Dept> deptList() {
        List<Dept> list = deptService.getDeptList();
        return list;
    }

    @RequestMapping("/deptAndTotalEmpList")
    public Map<String, Object> deptAndTotalEmpList(@RequestBody Map<String,String> map) {
        return deptService.getDeptAndTotalEmpList(map);
    }

    @RequestMapping("/addDept")
    public String addDept(@RequestBody Map<String, String> deptForm) {
        return deptService.addDept(deptForm)? "success": "fail";
    }

    @RequestMapping("/updateDept")
    public String updateDept(@RequestBody Map<String, String> deptForm) {
        return deptService.updDept(deptForm)? "success": "fail";
    }

    @RequestMapping("/delDepts")
    public String delDepts(@RequestBody List<Integer> deptnos) {
        return deptService.delDepts(deptnos)? "success": "fail";
    }

    @RequestMapping("/checkSameNameDept")
    public String checkSameNameDept(String dname){
        return deptService.getDeptnoByDname(dname);
    }
}
