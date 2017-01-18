package com.omg.service;

import com.omg.entity.Employee;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */
public interface EmployeeService {

    /**
     * 查询员工列表
     * @return
     */
    public List<Employee> getEmployeeList();

    /**
     * 条件查询
     * @param employeeName
     * @return
     */
    public List<Employee> getEmployeeListByName(String employeeName);

    /**
     * 删除员工
     * @param employeeId
     * @return
     */
    public int deleteEmployee(int employeeId);

    /**
     * 批量删除员工
     * @param arr
     * @return
     */
    public int batchDeleteEmployee(String[] arr);

    /**
     * 保存员工
     * @param employee
     * @return
     */
    public int saveEmployee(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);

    public Employee getEmployeeById(int employeeId);

}
