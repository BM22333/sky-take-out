package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     *
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     *员工分页查询
     * @param employeePageQueryDTO
     */
   Page<Employee> pageQuery(EmployeePageQueryDTO  employeePageQueryDTO);

    /**
     * 插入新员工
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) " +
            "values " +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);

    /**
     * 根据ID动态更新员工数据
     * @param employee
     */
    void update(Employee employee);
}
