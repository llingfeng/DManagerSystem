package com.omg.service.impl;

import com.omg.dao.EmployeeDao;
import com.omg.entity.Employee;
import com.omg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeDao.queryEmployeeList();
    }

    @Override
    public List<Employee> getEmployeeListByName(String employeeName) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        return employeeDao.queryEmployeeListByParam(employee);
    }

    @Override
    public int deleteEmployee(int employeeId) {
        return employeeDao.deleteEmployeeById(employeeId);
    }

    @Override
    public int batchDeleteEmployee(String[] arr) {
        if(arr != null && arr.length > 0){
            List<Integer> list = new ArrayList<>();
            for (String s : arr) {
                if(!"".equals(s.trim())){
                    list.add(Integer.parseInt(s));
                }
            }
            return employeeDao.batchDeleteEmployee(list);
        }
        return 0;
    }

    @Override
    public int saveEmployee(Employee employee) {
        if(employee != null){
            return employeeDao.addEmployee(employee);
        }
        return 0;
    }

    @Override
    public int updateEmployee(Employee employee) {
        if(employee != null){
            return employeeDao.updateEmployee(employee);
        }
        return 0;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.queryEmployeeById(employeeId);
    }
}
