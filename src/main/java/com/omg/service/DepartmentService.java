package com.omg.service;

import com.omg.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */
@Service
public interface DepartmentService {

    /**
     * 得到部门列表
     * @return
     */
    public List<Department> getDepartmentList();

    /**
     * 根据id查询部门
     * @return
     */
    public Department getDepartmentById(int id);

    /**
     * 根据条件查询部门
     * @param departmentName
     * @return
     */
    public List<Department> getDepartmentListByName(String departmentName);

    /**
     * 根据id删除部门
     * @param departmentId
     * @return
     */
    public int deleteDepartment(int departmentId);

    /**
     * 批量删除部门
     * @param arr
     * @return
     */
    public int batchDeleteDepartment(String[] arr);

    /**
     * 更新部门
     * @param department
     * @return
     */
    public int updateDepartment(Department department);

    /**
     * 添加部门
     * @param department
     * @return
     */
    public int saveDepartment(Department department);
}
