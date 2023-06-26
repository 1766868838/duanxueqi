package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BorrowService;

import jakarta.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @RequestMapping("borrow")
    public boolean borrow(String book_name,double card_num,String borrow_name,
    String borrow_date,String return_date,String return_type){

        if(borrowService.borrow()) return true;
        return false;
    }

}
