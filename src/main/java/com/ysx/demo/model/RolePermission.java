package com.ysx.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Date createDate;
    private String createBy;
    private Date editDate;
    private String editBy;
    private String delFlag;
}
