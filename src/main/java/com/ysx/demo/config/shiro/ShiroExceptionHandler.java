package com.ysx.demo.config.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ShiroExceptionHandler {

//    private static final Logger log = LoggerFactory.getLogger(ShiroExceptionHandler.class);

    @ExceptionHandler(value={AuthorizationException.class, UnauthorizedException.class})
    public Object unAuthorizationExceptionHandler(Exception e){

//        log.info("用户没有权限:{}",e.getMessage());
        System.out.println("用户没用权限");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 102);
        result.put("msg", "没有权限");
        result.put("data",null);
        return result;
    }
}
