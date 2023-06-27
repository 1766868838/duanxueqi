package com.example.demo.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.BorrowMapper;
import com.example.demo.pojo.Borrow;

import jakarta.annotation.Resource;

@Service
public class BorrowService {
    
    @Resource
    private BorrowMapper borrowMapper;

    public boolean borrow(String book_name,int book_id, double card_num, String borrow_name, Timestamp borrow_date, Timestamp return_date, String return_type){
        try {
            Borrow borrow = new Borrow(book_name,book_id,card_num,borrow_name,borrow_date,return_date,return_type);
            borrowMapper.insert(borrow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 借阅图书
     * @param borrow
     * @return
     */
    public boolean borrow(Borrow borrow){
        try {
            borrowMapper.insert(borrow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
