package com.servie.impl;

import com.dao.UserMapper;
import com.domain.User;
import com.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User findById(int id) {
        return userMapper.findById(1);
    }
}
