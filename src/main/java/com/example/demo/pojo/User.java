package com.example.demo.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 读者实体类
 */
@Data
@TableName("user")
public class User implements Serializable{
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, Double cardNum, String phoneNum,int gender) {
        this.username = username;
        this.password = password;       
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.identity = 0;
        this.gender = gender;
        this.borrowing = 0;
    }
    public User(Double cardNum,String username, String password, String phoneNum,int identity,int gender,int borrowing) {
        this.username = username;
        this.password = password;       
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.gender = gender;
        this.borrowing = borrowing;
    }
    @TableField("card_num")
    private double cardNum;

    @TableField("user_name")
    private String username;

    @TableField("password")
    private String password;

    @TableField("phone_num")
    private String phoneNum;

    @TableField("identity_type")
    private int identity;

    @TableField("borrow_num")
    private int borrowing;

    @TableField("gender")
    private int gender;
}
