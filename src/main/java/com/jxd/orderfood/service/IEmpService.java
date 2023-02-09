package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IEmpService extends IService<Emp> {
    String getEmpPwd(Integer empno);    // 待废弃

    /**
     * 查询员工个人信息
     * @param map
     * @return
     */
    Map<String, Object> getEmpInfoByEname(Map<String,String> map);

    /**
     * 获取一个部门的员工
     * @param
     * @return
     */
    List<Emp> getEmpListByDept(int deptno);

    List<String> getEnameByEmpnos(List<Integer> empnos);

    Map<String, Object> getAllEmpList(Map<String,String> map);

    boolean delEmps(List<Integer> empnos);

    String getEmpnoByEname(String ename);

    boolean addEmp(Map<String, String> empForm);

    boolean updEmp(Map<String, String> empForm);

    boolean updEmpDeptnoToToDelete(List<String> empnos);
}
