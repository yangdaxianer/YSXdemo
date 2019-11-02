package com.ysx.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date createDate;
    private String createBy;
    private Date editDate;
    private String editBy;
    private String delFlag;
}
