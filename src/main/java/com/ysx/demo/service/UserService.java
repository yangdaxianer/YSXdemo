package com.ysx.demo.service;

import com.ysx.demo.model.User;

import java.util.List;

public interface UserService {
    // 用户注册
    boolean addUser(User user);
    // 修改密码
    boolean modifyPassword(User user);
    //更具username查询
    List<User> findByUsername(String username);
}
