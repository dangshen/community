package com.example.community.web;

import com.example.community.domain.User;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping("/user")
    @ResponseBody
    public List<User> user(@RequestBody User user) {
        System.out.println(user);
        if(userService.login(user) != null) {
            return userService.getAllUser();
        } else {
            return null;
        }
    }
}
