package com.linxin.springboot01.dao;

import com.linxin.springboot01.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxin
 * @date 9/27/2021 - 10:46 AM
 * @file DepartmentDao.java
 * @function 部门Dao
 */
@Repository
public class DepartmentDao {

    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>(); // 创建一个部门表
        departments.put(101,new Department(101,"基础技术所"));
        departments.put(102,new Department(102,"高压所"));
        departments.put(103,new Department(103,"驱动所"));
        departments.put(104,new Department(104,"工艺所"));
        departments.put(105,new Department(105,"信通所"));
        departments.put(106,new Department());
    }

    // 获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    // 通过id获得部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

    //
}
