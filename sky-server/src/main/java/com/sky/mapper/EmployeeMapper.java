package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from sky_take_out.employee where username = #{username}")
    Employee getByUsername(String username);


    //添加员工
    @AutoFill(OperationType.INSERT)//进行aop管理
    @Insert("insert into sky_take_out.employee (name,username,password,phone,sex,id_number,status,create_time,update_time,create_user,update_user)" +
            "values(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void addEmp(Employee employee);

    //分页查询员工
    Page<Employee> searchPage(EmployeePageQueryDTO employeePageQueryDTO);

    //启用禁用账户
    void startOrStop(Employee employee);

    @Select("select * from sky_take_out.employee where id = #{id}")
    Employee getByid(Long id);

    //修改员工信息
    @AutoFill(OperationType.UPDATE)//进行aop管理
    @Update("update employee set name = #{name},username = #{username},phone = #{phone},sex = #{sex},id_number = #{idNumber},update_time = #{updateTime},update_user = #{updateUser} where id = #{id}")
    void update(Employee employee);



}
