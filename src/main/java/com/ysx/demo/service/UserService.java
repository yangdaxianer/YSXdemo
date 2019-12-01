package com.ysx.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysx.demo.model.User;
import org.eclipse.jdt.internal.compiler.env.IModule;

import java.util.List;

public interface UserService extends IService<User> {
    boolean addUser(User user);
    List<User> findUserByUsername(String username);
}
