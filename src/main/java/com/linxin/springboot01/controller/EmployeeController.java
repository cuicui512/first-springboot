package com.linxin.springboot01.controller;

import com.linxin.springboot01.dao.DepartmentDao;
import com.linxin.springboot01.dao.EmployeeDao;
import com.linxin.springboot01.pojo.Department;
import com.linxin.springboot01.pojo.Employee;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author linxin
 * @date 9/28/2021 - 9:27 AM
 * @file EmployeeController.java
 * @function 员工管理页面
 */
@Controller
public class EmployeeController {
    // controller应该调用server层，这里直接调用了dao层的数据，为了展示
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 跳转到员工信息展示页面
    @RequestMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getALL();
        model.addAttribute("employees",employees);
        // return 到template目录下的/employee/list.html页面
        return "employee/list";
    }

    // 跳转到添加源页面
    @GetMapping("/employee") // get请求，只能获得跳转
    public String toAddPage(Model model){
        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "employee/add";
    }


    // 拿到add.html中表单数据后实现添加员工信息
    @PostMapping("/employees") // post请求，拿到添加员工页面add.html的表单输入数据
    public String addEmployee(Employee employee){
        // 添加数据
        System.out.println(employee);
        // 调用底层业务方法保存员工数据
        employeeDao.save(employee);

        return "redirect:/employees";
    }

    // 跳转到编辑员工页面
    @GetMapping("/employee/{id}") //获取到/employee下的{id}
    public String toUpdateEmployee(@PathVariable("id")Integer id,Model model){
        // 查出原来的数据
        Employee employeeById = employeeDao.getEmployeeById(id);
        // 返回数据到前端页面
        model.addAttribute("employee",employeeById);

        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        //转到employee/update.html
        return "employee/update";
    }

    // 拿到update.html中表单数据后实现修改员工信息
    @PostMapping("/employees/update") // post请求，拿到修改员工页面update.html的表单输入数据
    public String update(Employee employee){
        // 添加数据
        System.out.println(employee);
        // 调用底层业务方法保存员工数据
        employeeDao.save(employee);

        return "redirect:/employees";
    }

    // 删除员工
    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable("id")int id,Model model){

        employeeDao.delete(id);
        return "redirect:/employees";
    }
}
