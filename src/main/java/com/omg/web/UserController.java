package com.omg.web;

import com.omg.entity.User;
import com.omg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by admin on 2016/11/20.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到修改页面
     * @param session
     * @param map
     * @return
     */
    @RequestMapping(value = "modifyPassword",method = RequestMethod.GET)
    public String jumpToModifyPage(HttpSession session, Map<String,Object> map){
        String userName = (String) session.getAttribute("userName");
        User user =userService.getUserByUserName(userName);
        map.put("user",user);
        return "user_modify";
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping(value = "modifyPassword",method = RequestMethod.POST)
    public String modifyPassword(User user,HttpSession session){
        userService.updateUser(user);
        session.setAttribute("userName",user.getUserName());
        return "redirect:/showDepartmentList";
    }
}
