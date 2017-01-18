package com.omg.dao;

import com.omg.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/11/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DepartmentDaoTest {

    @Resource
    private DepartmentDao departmentDao;
    @Test
    public void queryDepartmentList() throws Exception {
        List<Department> list =  departmentDao.queryDepartmentList();
        for (Department department : list) {
            System.out.print(department);
        }
    }

}