package com.omg.dao;

import com.omg.entity.Employee;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */
public interface EmployeeDao {

    /**
     * 增加员工
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 根据id删除员工
     * @param employeeId
     * @return
     */
    int deleteEmployeeById(int employeeId);

    /**
     * 批量删除员工
     * @param list
     * @return
     */
    int batchDeleteEmployee(List<Integer> list);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Employee queryEmployeeById(int id);

    /**
     * 查询员工列表
     * @return
     */
    List<Employee> queryEmployeeList();

    /**
     * 条件查询员工列表
     * @param employee
     * @return
     */
    List<Employee> queryEmployeeListByParam(Employee employee);
}
