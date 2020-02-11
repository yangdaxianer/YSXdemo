package com.ysx.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 借书记录表
 */
@Data
@TableName(value = "borrow_records")
public class BorrowRecords implements Serializable {
    private static final long serialVersionUID = -3341378581377520507L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value = "user_id")
    private Integer bookId;
    //记录生成时间
    @TableField(value = "createTime")
    private Date createTime;
    //借书状态，0正在借阅，1归还，2,已预约但是未借
    @TableField(value = "status")
    private String status;
    //借出时间
    @TableField(value = "borrowTime")
    private Date borrowTime;
    //归还时间
    @TableField(value = "returnTime")
    private Date returnTime;

}
