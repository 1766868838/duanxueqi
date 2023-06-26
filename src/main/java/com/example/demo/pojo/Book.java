package com.example.demo.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


/**
 * 图书实体类
 */
@Data
@TableName("books")
public class Book {
    @TableId("ID")
    private Integer id;
    @TableField("book_name")
    private String bookName;
    public Book(Integer id, String bookName, String bookType, String author, float price, String language, String press,
            Date publicationDate, String introduce, int is_borrow) {
        this.id = id;
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.price = price;
        this.language = language;
        this.press = press;
        this.publicationDate = publicationDate;
        this.introduce = introduce;
        this.is_borrow = is_borrow;
    }
    @TableField("book_type")
    private String bookType;
    @TableField("author")
    private String author;
    @TableField("price")
    private float price;
    @TableField("language")
    private String language;
    @TableField("press")
    private String press;
    @TableField("publication_date")
    private Date publicationDate;
    @TableField("introduce")
    private String introduce;
    @TableField("is_borrow")
    private int is_borrow;
}
