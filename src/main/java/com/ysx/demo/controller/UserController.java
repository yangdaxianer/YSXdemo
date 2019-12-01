package com.ysx.demo.controller;


import com.ysx.demo.model.User;
import com.ysx.demo.service.UserService;
import com.ysx.demo.utils.RandomString;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;



}
