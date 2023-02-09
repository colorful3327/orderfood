package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Admin;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IAdminService;
import com.jxd.orderfood.service.IEmpService;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/getEmpInfo")
    public Map<String,Object> getEmpInfo(@RequestBody Map<String,String> map) {
        return empService.getEmpInfoByEname(map);
    }

    @RequestMapping("/getEmpListByDept")
    public List<Emp> getEmpListByDept(int deptno) {
        List<Emp> list = empService.getEmpListByDept(deptno);
        return list;
        // return empService.getEmpListByDept(deptno);
    }

    @RequestMapping("/listEmp")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return empService.getAllEmpList(map);
    }
    // @RequestMapping("getEnameByEmpnos")
    // public List<String> selectEnameByEmpnos(@RequestBody List<Integer> empnos) {
    //     return empService.getEnameByEmpnos(empnos);
    // }

    // @RequestMapping("/loginEmp")
    // public String loginEmp(@RequestBody User user) {
    //     String realPwd = empService.getEmpPwd(user.getAccount());
    //     if(user.getPassword().equals(realPwd)){
    //         return "success";
    //     }else{
    //         return "error";
    //     }
    // }
    //
    // @RequestMapping("/loginAdmin")
    // public String loginAdmin(@RequestBody User user) {
    //     String realPwd = adminService.getAdminPwd(user.getAccount());
    //     if(user.getPassword().equals(realPwd)){
    //         return "success";
    //     }else{
    //         return "error";
    //     }
    // }

    @RequestMapping("/delEmps")
    public String delEmps(@RequestBody List<Integer> empnos) {
        return empService.delEmps(empnos)? "success": "fail";
    }

    // plus
    // @RequestMapping("/addEmp")
    // @Transactional
    // public String addEmp(@RequestBody Emp emp){
    //     if(empService.save(emp)){
    //         return "success";
    //     }else{
    //         return "error";
    //     }
    // }
    @RequestMapping("/addEmp")
    @Transactional
    public String addEmp(@RequestBody Map<String, String> empForm){
        boolean isSuccessAddEmp = empService.addEmp(empForm);
        boolean isSuccessAddUser = userService.addUser(empForm);
        return isSuccessAddEmp && isSuccessAddUser? "success": "fail";
    }

    // @RequestMapping("/updateEmp")
    // public String updateEmp(@RequestBody Emp emp){
    //     if(empService.saveOrUpdate(emp)){
    //         return "success";
    //     }else{
    //         return "error";
    //     }
    // }

    @RequestMapping("/updateEmp")
    @Transactional
    public String updateEmp(@RequestBody Map<String, String> empForm){
        boolean isSuccessUpdEmp = empService.updEmp(empForm);
        boolean isSuccessUpdUser = userService.updUname(empForm.get("olduname"), empForm.get("ename"));
        return isSuccessUpdEmp && isSuccessUpdUser? "success": "fail";
    }

    // 更新员工信息，员工表的姓名变了，你那个账户表也要更新名字，
    // 存下来老名字，传给后台，根据老名字去查询密码和工作，删除原来的账户，把新名字老密码老工作插入。
    // emp 直接update，user 先select再delete再insert

    @RequestMapping("/checkSameName")
    public String checkSameName(String ename){
        return empService.getEmpnoByEname(ename);
    }

    @RequestMapping("/updEmpDeptnoToToDelete")
    @Transactional
    public String updEmpDeptnoToToDelete(@RequestBody List<String> enames){
        boolean isSuccessDelEmps = empService.updEmpDeptnoToToDelete(enames);
        boolean isSuccessDelUsers = userService.delUsers(enames);
        return isSuccessDelEmps && isSuccessDelUsers? "success": "fail";
    }
}
