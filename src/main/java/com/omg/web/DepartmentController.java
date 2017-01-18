package com.omg.web;

import com.omg.entity.Department;
import com.omg.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/11/18.
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "showDepartmentList",method = RequestMethod.GET)
    public String showDepartmentList(Map<String,Object> map,HttpServletRequest request){
        return showDepartmentListByParam(map,request);
    }

    /**
     * 显示部门列表
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "showDepartmentList",method = RequestMethod.POST)
    public String showDepartmentListByParam(Map<String,Object> map, HttpServletRequest request){
        String departmentName = request.getParameter("departmentName");
        List<Department> departmentList = departmentService.getDepartmentListByName(departmentName);
        map.put("departmentList",departmentList);
        map.put("departmentName",departmentName);
        return "department_list";
    }

    /**
     * 删除部门
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteDepartment",method = RequestMethod.DELETE)
    public Map deleteDepartment(@RequestBody Department department){
        int num = departmentService.deleteDepartment(department.getDepartmentId());
        Map map = new HashMap();
        map.put("num",num);
        map.put("departmentName",department.getDepartmentName());
        return map;
    }

    /**
     * 批量删除
     * @param request
     * @return
     */
    @RequestMapping(value = "batchDeleteDepartment",method = RequestMethod.DELETE)
    public ModelAndView batchDeleteDepartment(HttpServletRequest request){
        String[] departmentIds = request.getParameterValues("departmentId");
        String departmentName = request.getParameter("departmentName");
        departmentService.batchDeleteDepartment(departmentIds);
        ModelMap modelMap = new ModelMap();
        if(!"".equals(departmentName.trim())){
            modelMap.put("departmentName",departmentName);
        }
        return new ModelAndView("redirect:/showDepartmentList",modelMap);
    }

    /**
     * 跳转到新增页面
     * @param map
     * @return
     */
    @RequestMapping(value = "addDepartment",method = RequestMethod.GET)
    public String toAddDepartmentPage(Map<String,Object> map){
        List<Department> departmentList = departmentService.getDepartmentList();
        Department newDepartment = new Department();
        newDepartment.setDepartmentId(0);
        newDepartment.setDepartmentName("");
        departmentList.add(newDepartment);
        map.put("department",new Department());
        map.put("departmentList",departmentList);
        return "department_add";
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @RequestMapping(value = "addDepartment",method = RequestMethod.PUT)
    public String addDepartment(Department department){
        departmentService.saveDepartment(department);
        return "redirect:/showDepartmentList";
    }

    /**
     * 跳转到修改页面
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "modifyDepartment",method = RequestMethod.GET)
    public String toModifyDepartmentPage(Map<String,Object> map,HttpServletRequest request){
        String departmentId = request.getParameter("departmentId");
        Department department = departmentService.getDepartmentById(Integer.parseInt(departmentId));
        List<Department> departmentList = departmentService.getDepartmentList();
        Department newDepartment = new Department();
        newDepartment.setDepartmentId(0);
        newDepartment.setDepartmentName("");
        departmentList.add(newDepartment);
        map.put("department",department);
        map.put("departmentList",departmentList);
        return "department_add";
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @RequestMapping(value = "addDepartment",method = RequestMethod.POST)
    public String modifyDepartment(Department department){
        departmentService.updateDepartment(department);
        return "redirect:showDepartmentList";
    }
}
