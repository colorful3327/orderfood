package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper extends BaseMapper<Emp> {
    /**
     * 查询员工密码 -                 已废弃 待删除
     *
     * @param empno
     * @return
     */
    String selectEmpPwd(@Param("empno") Integer empno);


    /**
     * 查询个人页信息
     * @param map
     * @return
     */
    Map<String, Object> selectEmpInfoByEname(
        @Param("queryMap") Map<String,String> map);

    /**
     * 查一个部门都有谁
     * @param deptno
     * @return
     */
    List<Emp> selectEmpListByDept(@Param("deptno") int deptno);
    // List<Emp> selectEmpListByDept(@Param("dname") String dname);

    List<String> selectEnameByEmpnos(List<Integer> empnos);

    IPage<Emp>  getAllEmpList(IPage<Emp> page,
        @Param("ename") String ename,@Param("deptno") int deptno);

    boolean deleteEmps(@Param("empnos") List<Integer> empnos);

    String selectEmpnoByEname(@Param("ename") String ename);

    boolean insertEmp(@Param("empForm") Map<String, String> empForm);

    boolean updateEmp(@Param("empForm") Map<String, String> empForm);

    /**
     * 更新部门到废部
     * @param enames
     * @return
     */
    boolean updateEmpDeptnoToToDelete(@Param("enames") List<String> enames);
}
