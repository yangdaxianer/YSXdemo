package com.ysx.demo.system;

import com.ysx.demo.controller.UserController;
import com.ysx.demo.model.User;
import com.ysx.demo.service.UserService;
import com.ysx.demo.utils.RandomString;
import com.ysx.demo.utils.ShiroPwdUtil;
import com.ysx.demo.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@CrossOrigin
@RestController
public class RegisterAndLoginController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RegisterAndLoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Object register(@RequestBody Map<String,Object> map){
        try {
            String username = (String) map.get("username");
            //前端传递过来的明文
            String pwd = (String) map.get("password");
            //产生盐值
            String salt = RandomString.getRandomString(32);
            String password = ShiroPwdUtil.encryptionPwd(pwd, salt);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setSalt(salt);
            if(userService.addUser(user)){
                return "注册成功";
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return "注册失败";
    }

    @RequestMapping("/login")
    public Object login(@RequestBody Map<String,Object> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        if(StringUtil.isNotEmpty(username)&&!StringUtil.isNotEmpty(password)){
            try{
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                Serializable SessionId = subject.getSession().getId();
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
