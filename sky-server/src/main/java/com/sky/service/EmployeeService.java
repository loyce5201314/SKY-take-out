package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);


    //添加员工
    void addEmp(EmployeeDTO employeeDTO);

    //分页查询员工
    PageResult SearchPage(EmployeePageQueryDTO employeePageQueryDTO);

    //启用或者禁用账号
    void startOrStop(Long id, Integer status);

    //根据id查询员工
    Employee getById(Long id);


    //修改员工
    void update(EmployeeDTO employeeDTO);
}
