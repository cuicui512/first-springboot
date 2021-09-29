package com.linxin.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author linxin
 * @date 9/27/2021 - 10:40 AM
 * @file Employee.java
 * @function 伪造数据 员工表
 */
@Data
//@AllArgsConstructor // 有参
@NoArgsConstructor // 无参
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; // 0:女 ；1:男
    private Department department;
    private Date birth;

    // 自定义有参构造，将birth的日期设为自动
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        // 默认创建日期
        this.birth = new Date();
    }
}
