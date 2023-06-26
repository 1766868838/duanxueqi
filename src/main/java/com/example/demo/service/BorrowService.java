package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.BorrowMapper;

import jakarta.annotation.Resource;

@Service
public class BorrowService {
    
    @Resource
    private BorrowMapper borrowMapper;

    
    public boolean borrow(){
        return false;
    }
}
