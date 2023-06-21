package com.example.demo.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * 读者实体类
 */
@Data
public class User implements Serializable{
    private String username;
    private String password;
    private String phone;
    private String identity;
    private String borrowing;
}
