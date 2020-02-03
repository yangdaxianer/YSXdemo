package com.ysx.demo.controller;


import com.ysx.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping(value = "/user/get",method = RequestMethod.POST)
    public Object getUserInfo(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        return userService.findUserByUsername(username);
    }



}
