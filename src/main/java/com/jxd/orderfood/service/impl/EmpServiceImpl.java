package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.model.Order;
import com.jxd.orderfood.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public String getEmpPwd(Integer empno) {
        return empMapper.selectEmpPwd(empno);
    }

    @Override
    public Map<String, Object> getEmpInfoByEname(Map<String, String> queryMap) {
        Map<String, Object> map = new HashMap();
        map.put("data", empMapper.selectEmpInfoByEname(queryMap));
        return map;
    }

    @Override
    public List<Emp> getEmpListByDept(int deptno) {
        return empMapper.selectEmpListByDept(deptno);
    }

    @Override
    public List<String> getEnameByEmpnos(List<Integer> empnos) {
        return empMapper.selectEnameByEmpnos(empnos);
    }

    @Override
    public Map<String, Object> getAllEmpList(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("ename");
        String deptnos = queryMap.get("deptno");
        int deptno = 0;
        if(!"".equals(deptnos)){
            deptno = Integer.parseInt(deptnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Emp> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Emp> pageResult = empMapper.getAllEmpList(pages,ename,deptno);
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
    public boolean delEmps(List<Integer> empnos) {
        return empMapper.deleteEmps(empnos);
    }

    @Override
    public String getEmpnoByEname(String ename) {
        return empMapper.selectEmpnoByEname(ename);
    }

    @Override
    public boolean addEmp(Map<String, String> empForm) {
        return empMapper.insertEmp(empForm);
    }

    @Override
    public boolean updEmp(Map<String, String> empForm) {
        return empMapper.updateEmp(empForm);
    }

    @Override
    public boolean updEmpDeptnoToToDelete(List<String> enames) {
        return empMapper.updateEmpDeptnoToToDelete(enames);
    }
}
