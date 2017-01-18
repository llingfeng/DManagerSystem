package com.omg.entity;

import java.util.Date;

/**
 * Created by admin on 2016/11/19.
 */
public class Employee {
    private int employeeId;
    private String employeeName;
    private short employeeSexy;
    private Date createTime;
    private Date updateTime;
    private int departmentId;
    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public short getEmployeeSexy() {
        return employeeSexy;
    }

    public void setEmployeeSexy(short employeeSexy) {
        this.employeeSexy = employeeSexy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
