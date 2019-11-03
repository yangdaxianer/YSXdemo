package com.ysx.demo.mapper;

import com.ysx.demo.model.User;

import java.util.List;

public interface UserMapper {

    //根据账号查找user
    List<User> findByUsername(String username);
    //注册用户
    int insertUser(User user);
    //修改密码
    int updatePassword(User user);
}
