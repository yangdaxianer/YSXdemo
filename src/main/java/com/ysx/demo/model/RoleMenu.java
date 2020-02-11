package com.ysx.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role_menu")
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -8277873862571545230L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "roleId")
    private Integer roleId;
    @TableField(value = "userId")
    private Integer userId;
}
