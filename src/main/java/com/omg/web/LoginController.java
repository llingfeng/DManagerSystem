package com.omg.web;

import com.omg.entity.User;
import com.omg.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2016/11/20.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        User user = userService.getUserByUserNameAndPassword(userName,userPassword);
        if(user != null){
            session.setAttribute("userName",user.getUserName());
            return "redirect:/showDepartmentList";
        }
        return "redirect:/jumpToLoginPage";
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/jumpToLoginPage";
    }

}
