package com.ysx.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysx.demo.mapper.UserMapper;
import com.ysx.demo.model.User;
import com.ysx.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user) {
        if(baseMapper.insert(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> findUserByUsername(String username) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("username", username);
        columnMap.put("delFlag","0");
        return baseMapper.selectByMap(columnMap);
    }
}
