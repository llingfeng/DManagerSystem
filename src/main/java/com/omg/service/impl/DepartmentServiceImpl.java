package com.omg.service.impl;

import com.omg.dao.DepartmentDao;
import com.omg.entity.Department;
import com.omg.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.queryDepartmentList();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDao.queryDepartmentById(id);
    }

    @Override
    public List<Department> getDepartmentListByName(String departmentName) {
        Department department = new Department();
        department.setDepartmentName(departmentName);
        return departmentDao.queryDepartmentListByParam(department);
    }

    @Override
    public int deleteDepartment(int departmentId) {
        return departmentDao.deleteDepartmentById(departmentId);
    }

    @Override
    public int batchDeleteDepartment(String[] arr) {
        if(arr != null && arr.length > 0){
            List<Integer> list = new ArrayList<>();
            for (String s : arr) {
                if(!"".equals(s.trim())){
                    list.add(Integer.parseInt(s));
                }
            }
            return departmentDao.batchDeleteDepartment(list);
        }
        return 0;
    }

    @Override
    public int updateDepartment(Department department) {
        if(department != null){
            departmentDao.updateDepartment(department);
        }
        return 0;
    }

    @Override
    public int saveDepartment(Department department) {
        if(department != null){
            return departmentDao.addDepartment(department);
        }
        return 0;
    }


}
