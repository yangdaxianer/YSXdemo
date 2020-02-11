package com.ysx.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = -8690731648658773927L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "salt")
    private String salt;
    @TableField(value = "phone")
    private String phone;
    @TableField(value = "email")
    private String email;
    @TableField(value = "address")
    private String address;
    @TableField(value = "balance")
    private String balance;
    @TableField(value = "lastSignIn")
    private Date lastSignIn;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField(value = "createDate")
    private Date createDate;
    @TableField(value = "createBy")
    private String createBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField(value = "editDate")
    private Date editDate;
    @TableField(value = "editBy")
    private String editBy;
    @TableField(value = "delFlag")
    private String delFlag;
}
