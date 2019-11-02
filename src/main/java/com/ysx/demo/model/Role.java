package com.ysx.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;
    private String role;
    private String roleName;
    private Date createDate;
    private String createBy;
    private Date editDate;
    private String editBy;
    private String delFlag;
}
