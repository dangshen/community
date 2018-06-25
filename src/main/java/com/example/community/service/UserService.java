package com.example.community.service;

import com.example.community.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 用户列表
     * @return
     */
    public List<User> getAllUser();

    /**
     * 注册
     * @param user
     * @return
     */
    public int signUp(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);
}
