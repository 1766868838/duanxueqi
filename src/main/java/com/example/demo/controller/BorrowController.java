package com.example.demo.controller;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Borrow;
import com.example.demo.service.BorrowService;

import jakarta.annotation.Resource;
import net.sf.jsqlparser.expression.TimestampValue;

/**
 * 借阅控制类
 */
@RestController
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    /* @RequestMapping("borrow")
    public boolean borrow(@RequestBody Borrow borrow){
        if(borrowService.borrow(borrow)) return true;
        return false;
    } */

    @RequestMapping("borrow")
    public boolean borrow(@RequestBody Borrow borrow){
        if(borrowService.borrow(borrow)) return true;
        return false;
    }

    /* public boolean borrow(String book_name,int book_id,double card_num,String borrow_name,
    String borrow_date,String return_date,String return_type){
        Timestamp borrowDate = Timestamp.valueOf(borrow_date);
        Timestamp returnDate = Timestamp.valueOf(return_date);
        if(borrowService.borrow(book_name,book_id,card_num,borrow_name,borrowDate,returnDate,return_type)) return true;
        return false;
    } */
}
