package com.ysx.demo.controller;


import com.ysx.demo.model.User;
import com.ysx.demo.service.UserService;
import com.ysx.demo.utils.RandomString;
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

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public Object getUsers(@RequestBody Map<String,Object> map){
        String username = (String) map.get("username");
        LOGGER.info("传入参数-----------------------"+username);
        if(username!=null){
            return userService.findByUsername(username);
        }
        return "查询失败";
    }

    @RequestMapping("/register")
    public Object register(@RequestBody Map<String,Object> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        //产生盐值
        String salt = RandomString.getRandomString(32);
        //将用户名当做盐值用于加密
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */

        String newPs = new SimpleHash("MD5", password,credentialsSalt,2).toHex();
        User user = new User();
        user.setUsername(username);
        user.setPassword(newPs);
        user.setSalt(salt);
        return "注册成功";
    }

    @RequestMapping("/login")
    public Object login(@RequestBody Map<String,Object> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        if(username!=null){
            try{
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                Serializable SessionId = subject.getSession().getId();
                System.out.println(SessionId);
                System.out.println("走到这里了");
                subject.login(token);
            }catch(LockedAccountException e){
                /**账号锁定*/
                return "账号锁定";
            }catch (IncorrectCredentialsException e) {
                /**密码错误*/
                return "密码错误";
            } catch (UnknownAccountException e) {
                /**账号不存在*/
                return "账号不存在";
            }

        }
        return username+"登录成功！";
    }


}
