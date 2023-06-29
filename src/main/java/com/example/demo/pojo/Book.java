package com.example.demo.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

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
        this.isBorrow = is_borrow;
    }
    @TableId("BID")
    private Integer id;
    @TableField("book_name")
    private String bookName;
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="YYYY-MM-DD")
    private Date publicationDate;
    @TableField("introduce")
    private String introduce;
    @TableField("is_borrow")
    private int isBorrow;
}
