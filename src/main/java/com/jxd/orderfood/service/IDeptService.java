package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDeptService extends IService<Dept> {
    List<Dept> getDeptList();

    Map<String, Object> getDeptAndTotalEmpList(Map<String,String> map);

    boolean addDept(Map<String, String> deptForm);

    boolean updDept(Map<String, String> deptForm);

    boolean delDepts(List<Integer> deptnos);

    String getDeptnoByDname(String dname);
}
