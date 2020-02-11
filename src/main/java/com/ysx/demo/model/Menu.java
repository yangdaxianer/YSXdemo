package com.ysx.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "sys_menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = -822217668056820111L;
    // 菜单id
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    // 菜单名称
    @TableField(value = "name")
    private String name;
    // 父菜单id
    @TableField(value = "parentId")
    private String parentId;
    // 菜单url
    @TableField(value = "url")
    private String url;
    // 菜单图标
    @TableField(value = "icon")
    private String icon;
    // 菜单顺序
    @TableField(value = "order")
    private int order;
    //菜单代码
    @TableField(value = "code")
    private String code;

}
