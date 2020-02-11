package com.ysx.demo.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书表
 */

@Data
@TableName(value = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -714289810416296534L;
    //主键id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //书名
    @TableField(value = "name")
    private String  name;
    //作者
    @TableField(value = "author")
    private String  author;
    //价格
    @TableField(value = "price")
    private Double  price;
    //出版信息
    @TableField(value = "press")
    private String  press;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //删除标志
    @TableField(value = "delFlag")
    private String delFlag;
    //状态，0未借出，1预约中，2已借出
    @TableField(value = "status")
    private String status;
    //图片地址
    @TableField(value = "image")
    private String image;
    //书本简介
    @TableField(value = "simpleInfo")
    private String simpleInfo;
    //书本数量
    @TableField(value = "num")
    private int num;
}
