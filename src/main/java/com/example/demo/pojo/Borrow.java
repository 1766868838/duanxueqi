package com.example.demo.pojo;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 借阅信息实体类
 * @param book_name 书名
 * @param book_id 书id
 * @param card_num 读者卡号
 * @param borrow_name 读者姓名
 * @param borrow_date 借阅日期
 * @param return_date 归还日期
 * @param return_type 归还类别
 */ 
@Data
@TableName("borrow")
public class Borrow {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("book_name")
    private String book_name;
    @TableField("book_id")
    private int book_id;
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

    public Borrow(String book_name,int book_id ,double card_num, String borrow_name, Timestamp borrow_date,
            Timestamp return_date, String return_type) {
        this.book_name = book_name;
        this.book_id = book_id;
        this.card_num = card_num;
        this.borrow_name = borrow_name;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.return_type = return_type;
    }

}
