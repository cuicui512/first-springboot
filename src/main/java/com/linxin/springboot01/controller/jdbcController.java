package com.linxin.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author linxin
 * @date 9/29/2021 - 9:17 AM
 * @file jdbcController.java
 * @function springboot通过jdbcTemplate实际操作数据库
 */

@RestController
@RequestMapping("/jdbc")
public class jdbcController {


    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询employee表中的所有数据
    // List 中的1个 Map 对应数据库的 1行数据
    // Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @GetMapping("/list")
    public List<Map<String,Object>> employeeList(){
        System.out.println("进入jdbcController-employeeList:");
        // sql语句，查询employee所有信息
        String sql = "select * from employee";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    // 新增一个员工
    @GetMapping("/add")
    public String addEmployee(){
        System.out.println("进入jdbcController-addEmployee:");
        String sql = "insert into employee(lastName,email,gender,department,birth) " +
                "values('林鑫','223651@qq.com',1,'西安','"+new Date().toLocaleString()+"')";
        // 执行插入SQL语句
        jdbcTemplate.update(sql);

        // 返回执行结果
        return "inserted!";
    }

    //修改员工信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        System.out.println("进入jdbcController-employeeUpdate:");
        //插入语句
        String sql = "update employee set lastName=?,email=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "AA";
        objects[1] = "24736743@sina.com";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updated";
    }

    //删除员工
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        System.out.println("进入jdbcController-employeeDelete:");
        //插入语句
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "deleted employee "+id;
    }


}
