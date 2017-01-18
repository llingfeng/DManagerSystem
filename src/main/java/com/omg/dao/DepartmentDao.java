package com.omg.dao;

import com.omg.entity.Department;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */
public interface DepartmentDao {
    /**
     * 无条件查询部门列表
     * @return
     */
    List<Department> queryDepartmentList();

    /**
     * 条件查询部门列表
     * @param department
     * @return
     */
    List<Department> queryDepartmentListByParam(Department department);

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    int deleteDepartmentById(int departmentId);

    /**
     * 批量删除
     * @param list
     * @return
     */
    int batchDeleteDepartment(List<Integer> list);

    /**
     * 增加部门
     * @return
     */
    int addDepartment(Department department);

    /**
     * 更新部门
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Department queryDepartmentById(int id);

}