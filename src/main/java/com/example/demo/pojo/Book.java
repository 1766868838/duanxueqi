package com.example.demo.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


/**
 * 图书实体类
 * @param id 图书id
 * @param bookName 书名
 * @param bookType 类别
 * @param author 作者
 * @param price 价格
 * @param language 语言
 * @param press 出版社
 * @param publicationDate 出版日期
 * @param introduce 图书介绍
 * @param is_borrow 是否借阅
 */
@Data
@TableName("books")
public class Book {
    @TableId("BID")
    private Integer id;
    @TableField("book_name")
    private String book_name;
    public Book(Integer id, String bookName, String bookType, String author, float price, String language, String press,
            Date publicationDate, String introduce, int is_borrow) {
        this.id = id;
        this.book_name = bookName;
        this.book_type = bookType;
        this.author = author;
        this.price = price;
        this.language = language;
        this.press = press;
        this.publication_date = publicationDate;
        this.introduce = introduce;
        this.is_borrow = is_borrow;
    }
    @TableField("book_type")
    private String book_type;
    @TableField("author")
    private String author;
    @TableField("price")
    private float price;
    @TableField("language")
    private String language;
    @TableField("press")
    private String press;
    @TableField("publication_date")
    private Date publication_date;
    @TableField("introduce")
    private String introduce;
    @TableField("is_borrow")
    private int is_borrow;
}
