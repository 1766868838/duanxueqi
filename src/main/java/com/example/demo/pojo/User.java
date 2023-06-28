package com.example.demo.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 读者实体类
 * 
 */
@Data
@TableName("user")
public class User implements Serializable{
    public User(){}
    public User(String cardNum, String username, String nickname, String email, String college, String password,
            String phoneNum, int identity, int borrowing, int gender) {
        this.cardNum = cardNum;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.college = college;
        this.password = password;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.borrowing = borrowing;
        this.gender = gender;
    }
    public User(String username, String password, String cardNum, String phoneNum,int gender,int identity) {
        this.username = username;
        this.password = password;       
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.gender = gender;
        this.borrowing = 0;
    }
    public User(Integer id, String cardNum,String username, String password, String phoneNum,int identity,int gender,int borrowing) {
        this.username = username;
        this.password = password;       
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.gender = gender;
        this.borrowing = borrowing;
    }

    public User(Integer id, String cardNum, String username, String nickname, String email, String college,
            String password, String phoneNum, int identity, int borrowing, int gender) {
        this.id = id;
        this.cardNum = cardNum;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.college = college;
        this.password = password;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.borrowing = borrowing;
        this.gender = gender;
    }

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    @TableField("card_num")
    private String cardNum;

    @TableField("user_name")
    private String username;

    @TableField("nick_name")
    private String nickname;
    @TableField("email")
    private String email;
    @TableField("college")
    private String college;

    @TableField(value = "password")
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
