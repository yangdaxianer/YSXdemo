package com.ysx.demo.controller;

import com.ysx.demo.config.DataSourceConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "测试类")
public class TestController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TestController.class);
    @Autowired
    private DataSourceConfig dataSourceConfig;

    @RequestMapping("/test")
    @ApiOperation(notes = "测试类",value = "无")
    public Object test(){
        LOGGER.info("logback日志生效了");
        System.out.println(dataSourceConfig.getUrl());
        System.out.println(dataSourceConfig.getPassword());
        System.out.println(dataSourceConfig.getUsername());
        return "ok";
    }
}
