package com.ysx.demo.service.Impl;

import com.ysx.demo.mapper.UserMapper;
import com.ysx.demo.model.User;
import com.ysx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean addUser(User user) {
        if(userMapper.insertUser(user)==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean modifyPassword(User user) {
        if(userMapper.updatePassword(user)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
