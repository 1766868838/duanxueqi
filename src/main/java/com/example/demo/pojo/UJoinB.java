package com.example.demo.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 读者借阅
 * 
 */
@Data
public class UJoinB implements Serializable{

    private String bookName;

    private String bookType;

    private String author;

    private String press;

    private Timestamp borrowDate;
}
