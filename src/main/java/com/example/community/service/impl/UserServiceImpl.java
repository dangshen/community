package com.example.community.service.impl;

import com.example.community.dao.mapper.UserMapper;
import com.example.community.domain.User;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public int signUp(User user) {
       return userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        return userMapper.selectOne(user);
    }
}
