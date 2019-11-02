package com.ysx.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class Permission {
    private Integer id;
    private String permission;
    private String url;
    private Date createDate;
    private String createBy;
    private Date editDate;
    private String editBy;
    private String delFlag;
}
