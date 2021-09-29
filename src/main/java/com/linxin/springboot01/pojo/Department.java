package com.linxin.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linxin
 * @date 9/27/2021 - 10:35 AM
 * @file Department.java
 * @function 伪造数据 Department表
 */
@Data
@AllArgsConstructor // 有参
@NoArgsConstructor // 无参
public class Department {
    private Integer id;
    private String departmentName;
}
