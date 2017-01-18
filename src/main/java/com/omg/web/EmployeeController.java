package com.omg.web;

import com.omg.entity.Department;
import com.omg.entity.Employee;
import com.omg.service.DepartmentService;
import com.omg.service.EmployeeService;
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
 * Created by admin on 2016/11/19.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "employeeList",method = RequestMethod.GET)
    public String employeeListGet(HttpServletRequest request, Map<String,Object> map){
        return employeeListPost(request,map);
    }

    /**
     * 查询所有用户
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "employeeList",method = RequestMethod.POST)
    public String employeeListPost(HttpServletRequest request, Map<String,Object> map){
        String employeeName = request.getParameter("employeeName");
        List<Employee> employeeList = employeeService.getEmployeeListByName(employeeName);
        map.put("employeeName",employeeName);
        map.put("employeeList",employeeList);
        return "employee_list";
    }

    /**
     * 删除部门
     * @param employee
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteEmployee",method = RequestMethod.DELETE)
    public Map deleteEmployee(@RequestBody Employee employee,Map<String,Object> map){
        int num = employeeService.deleteEmployee(employee.getEmployeeId());
        Map dataMap = new HashMap<>();
        dataMap.put("num",num);
        dataMap.put("employeeName",employee.getEmployeeName());
        return dataMap;
    }

    /**
     * 批量删除
     * @param request
     * @return
     */
    @RequestMapping(value = "batchDeleteEmployee",method = RequestMethod.DELETE)
    public ModelAndView batchDeleteEmployee(HttpServletRequest request){
        String[] arr = request.getParameterValues("employeeId");
        String employeeName = request.getParameter("employeeName");
        employeeService.batchDeleteEmployee(arr);
        ModelMap modelMap = new ModelMap();
        if(employeeName != null && !"".equals(employeeName.trim())){
            modelMap.put("employeeName",employeeName);
        }
        return  new ModelAndView("redirect:/employeeList",modelMap);
    }

    /**
     * 跳转到新增页面
     * @param map
     * @return
     */
    @RequestMapping(value = "addEmployee",method = RequestMethod.GET)
    public String toAddEmployeePage(Map<String,Object> map){
        List<Department> departmentList = departmentService.getDepartmentList();
        map.put("employee",new Employee());
        map.put("departmentList",departmentList);
        return "employee_add";
    }

    /**
     * 保存员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "addEmployee",method = RequestMethod.PUT)
    public String addEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employeeList";
    }

    /**
     * 跳转到修改页面
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "updateEmployee",method = RequestMethod.GET)
    public String toModifyEmployeePage(Map<String,Object> map,HttpServletRequest request){
        String employeeId = request.getParameter("employeeId");
        List<Department> departmentList = departmentService.getDepartmentList();
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(employeeId));
        map.put("employee",employee);
        map.put("departmentList",departmentList);
        return "employee_add";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "addEmployee",method = RequestMethod.POST)
    public String modifyEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employeeList";
    }
}
