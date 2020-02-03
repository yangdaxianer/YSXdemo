package com.ysx.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "sys_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 2768408880850948610L;
    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;
    private String role;
    private String roleName;
}
