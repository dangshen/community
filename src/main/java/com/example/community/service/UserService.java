package com.example.community.service;

import com.example.community.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 用户列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 注册
     * @param user
     * @return
     */
    int signUp(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 根据id查询用户
     * @param uId
     * @return
     */
    User findUserById(Integer uId);
}
