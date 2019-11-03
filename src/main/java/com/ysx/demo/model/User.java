package com.ysx.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private String address;
    private String balance;
    private Date lastSignIn;
    private Date createDate;
    private String createBy;
    private Date editDate;
    private String editBy;
    private String delFlag;
}
