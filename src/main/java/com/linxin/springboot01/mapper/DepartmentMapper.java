package com.linxin.springboot01.mapper;

import com.linxin.springboot01.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linxin
 * @date 9/29/2021 - 10:15 AM
 * @file DepartmentMapper.java
 * @function 对应Department的mapper层接口
 */

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface DepartmentMapper {
    // 获取所有部门信息
    List<Department> getDepartments();

    // 通过id获得部门
    Department getDepartment(Integer id);

}
