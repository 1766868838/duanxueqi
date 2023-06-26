package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import jakarta.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加读者
     * @return
     */
    @RequestMapping("/addReader")
    public boolean addReader(double cardNum,String username,String password,String phoneNum,int gender){

        if(userService.addReader(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    }

    @RequestMapping("/addManager")
    public boolean addManager(double cardNum,String username,String password,String phoneNum,int gender){

        if(userService.addReader(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    }
}
