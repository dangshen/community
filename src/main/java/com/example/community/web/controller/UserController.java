package com.example.community.web.controller;

import com.example.community.domain.User;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showSignUp")
    public String showSignUp() {
        return "user/signup";
    }
    //注册
    @RequestMapping("/signUp")
    @ResponseBody
    public Map<String, Object> signUp(@ModelAttribute("user") User user, HttpSession session) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            int result = userService.signUp(user);
            System.out.println("signUp result: " + result);
            if (result == 1) {
                session.setAttribute("user", user);
                returnMap.put("result", "注册成功");
                returnMap.put("user", user);
            } else {
                returnMap.put("result", "注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("result", "注册失败");
        }
        return returnMap;
    }

    @RequestMapping("/loginPage")
    public String showLogin() {
        return "/user/login";
    }
    //登录
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@ModelAttribute("user") User user, HttpSession session) {
        Map<String, Object> returnMap = new HashMap<>();
        System.out.println("--------------------user: " + user);
        User returnUser = userService.login(user);
        if(returnUser != null) {
            session.setAttribute("user", returnUser);
            returnMap.put("result", "登录成功");
            returnMap.put("user", returnUser);
        } else {
            returnMap.put("result", "登录失败");
        }
        return returnMap;
    }

    //退出登录
    @RequestMapping("/signOut")
    @ResponseBody
    public Map<String, Object> signOut(HttpSession session) {
        Map<String, Object> returnMap = new HashMap<>();
        session.setAttribute("user", null);
        returnMap.put("result", "退出登录");
        System.out.println("session user :　" + session.getAttribute("user"));
        return returnMap;
    }
}
