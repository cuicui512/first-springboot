package com.linxin.springboot01.dao;

import com.linxin.springboot01.pojo.Department;
import com.linxin.springboot01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxin
 * @date 9/27/2021 - 11:00 AM
 * @file EmployeeDao.java
 * @function EmployeeDao
 */
@Repository // 用于DepartmentDao和EmployeeDao传数据
public class EmployeeDao {

    // 模拟数据库中的数据
    private static Map<Integer,Employee> employees = null;
    // 员工有所属的部门
    @Autowired // 用于DepartmentDao和EmployeeDao传数据
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer,Employee>(); // 创建一个员工表
        employees.put(1001,new Employee(1001,"A","Alx@gmail.com",0,new Department(101,"信通所")));
        employees.put(1002,new Employee(1002,"B","Blx@gmail.com",0,new Department(102,"信通所")));
        employees.put(1003,new Employee(1003,"C","Clx@gmail.com",1,new Department(103,"信通所")));
        employees.put(1004,new Employee(1004,"D","Dlx@gmail.com",0,new Department(104,"信通所")));
        employees.put(1005,new Employee(1005,"E","Elx@gmail.com",1,new Department(105,"信通所")));
        //employees.put(1006,new Employee(1001,"AA","Alx@gamil.com",0,new Department()));

    }

    //主键自增
    private static  Integer initId = 1006;
    //添加员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);

    }

    // 查询员工全部信息
    public Collection<Employee> getALL(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }


}
