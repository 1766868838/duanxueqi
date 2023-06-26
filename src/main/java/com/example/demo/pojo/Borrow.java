package com.example.demo.pojo;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("borrow")
public class Borrow {
    @TableId("id")
    private Integer id;
    @TableField("book_name")
    private String book_name;
    @TableField("card_num")
    private double card_num;
    @TableField("borrow_name")
    private String borrow_name;
    @TableField("borrow_date")
    private Timestamp borrow_date;
    @TableField("return_date")
    private Timestamp return_date;
    @TableField("return_type")
    private String return_type;
}
