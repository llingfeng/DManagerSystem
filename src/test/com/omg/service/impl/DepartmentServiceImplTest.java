package com.omg.service.impl;

import com.omg.entity.Department;
import com.omg.service.DepartmentService;
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
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class DepartmentServiceImplTest {
    @Resource
    private DepartmentService departmentService;

    @Test
    public void getDepartmentListByName() throws Exception {
        List<Department> departmentList = departmentService.getDepartmentListByName("经理");
        for (Department department : departmentList) {
            System.out.print(department);
        }
    }

}