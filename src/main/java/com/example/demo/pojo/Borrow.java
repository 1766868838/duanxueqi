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
    @TableField("book_id")
    private int bookId;
    @TableField("book_name")
    private String bookName;
    @TableField("card_num")
    private String cardNum;
    @TableField("borrow_name")
    private String borrowName;
    @TableField("borrow_date")
    private Timestamp borrowDate;
    @TableField("return_date")
    private Timestamp returnDate;
    @TableField("return_type")
    private String returnType;

    public Borrow(Integer id,int book_id ,String book_name,String card_num, String borrow_name, Timestamp borrow_date,
            Timestamp return_date, String return_type) {
        this.id = id;
        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowName = borrow_name;
        this.borrowDate = borrow_date;
        this.returnDate = return_date;
        this.returnType = return_type;
    }

    public Borrow(){}

    public Borrow(Integer id,String book_name,int book_id ,String card_num, String borrow_name, Timestamp borrow_date,
            Timestamp return_date) {
        this.id = id;
        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowName = borrow_name;
        this.borrowDate = borrow_date;
        this.returnDate = return_date;
    }
    public Borrow(Integer id,String book_name,int book_id ,String card_num, String borrow_name, Timestamp borrow_date) {
        this.id = id;
        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowName = borrow_name;
        this.borrowDate = borrow_date;
    }

    public Borrow(String book_name,int book_id ,String card_num, String borrow_name, Timestamp borrow_date) {
        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowName = borrow_name;
        this.borrowDate = borrow_date;
    }

    public Borrow(String book_name,int book_id ,String card_num, Timestamp borrow_date) {
        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowDate = borrow_date;
    }

    public Borrow(String book_name, int book_id, String card_num, String borrow_name, Timestamp borrow_date,
            Timestamp return_date, String return_type) {

        this.bookName = book_name;
        this.bookId = book_id;
        this.cardNum = card_num;
        this.borrowName = borrow_name;
        this.borrowDate = borrow_date;
        this.returnDate = return_date;
    }
}
