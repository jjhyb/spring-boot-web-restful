package com.yibo.springbootwebrestful.controller;

import com.yibo.springbootwebrestful.dao.DepartmentDao;
import com.yibo.springbootwebrestful.dao.EmployeeDao;
import com.yibo.springbootwebrestful.entities.Department;
import com.yibo.springbootwebrestful.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/13 16:07
 * @Description:
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工返回列表页面
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 员工添加页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //在跳转到员工添加页面之前应该查出所有部门用于显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        /**
         * redirect: 重定向到一个地址 /代表当前项目路径
         * forword: 转发到一个地址
         */
        return "redirect:/emps";
    }

    /**
     * 根据id查询员信息
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     */
    @DeleteMapping("/emp/123/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
