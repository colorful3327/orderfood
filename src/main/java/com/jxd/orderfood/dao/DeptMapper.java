package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends BaseMapper<Dept> {
    List<Dept> selectDeptList();

    // List<Map<String, Object>> selectDeptAndTotalEmpList();

    IPage<Dept> selectDeptAndTotalEmpList(
        IPage<Dept> page, @Param("queryMap") Map<String,String> map);

    boolean insertDept(@Param("deptForm") Map<String, String> deptForm);

    boolean updateDept(@Param("deptForm") Map<String, String> deptForm);

    boolean deleteDepts(@Param("deptnos") List<Integer> deptnos);

    String selectDeptnoByDname(@Param("dname") String dname);
}
