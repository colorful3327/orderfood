package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.DeptMapper;
import com.jxd.orderfood.dao.FoodMapper;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.model.Order;
import com.jxd.orderfood.service.IDeptService;
import com.jxd.orderfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/2/6
 * @Version 1.0
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.selectDeptList();
    }

    @Override
    public Map<String, Object> getDeptAndTotalEmpList(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Dept> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Dept> pageResult = deptMapper.selectDeptAndTotalEmpList(pages, queryMap);
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
    public boolean addDept(Map<String, String> deptForm) {
        return deptMapper.insertDept(deptForm);
    }

    @Override
    public boolean updDept(Map<String, String> deptForm) {
        return deptMapper.updateDept(deptForm);
    }

    @Override
    public boolean delDepts(List<Integer> deptnos) {
        return deptMapper.deleteDepts(deptnos);
    }

    @Override
    public String getDeptnoByDname(String dname) {
        return deptMapper.selectDeptnoByDname(dname);
    }

}
