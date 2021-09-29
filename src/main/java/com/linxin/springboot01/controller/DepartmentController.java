package com.linxin.springboot01.controller;

import com.linxin.springboot01.mapper.DepartmentMapper;
import com.linxin.springboot01.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linxin
 * @date 9/29/2021 - 10:53 AM
 * @file DepartmentController.java
 * @function 联合DepartmentMapper实现业务
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    // 查询全部部门
    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        List<Department> departmentList = departmentMapper.getDepartments();
        for(Department department :departmentList){
            System.out.println(department);
        }
        return departmentMapper.getDepartments();
    }

    // 根据id查询部门
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDepartment(id);
    }

}
