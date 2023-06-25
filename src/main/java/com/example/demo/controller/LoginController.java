package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;

import jakarta.annotation.Resource;

/**
 * 登录控制类
 */
@RestController

public class LoginController {
    
    @Resource
    public UserMapper userMapper;

    @Resource
    public LoginService loginService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public boolean login(double cardNum,String password){
        
        if(loginService.login(cardNum, password)){
            return true;
        }

        return false;
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/regist")
    public boolean regist(double cardNum,String username,String password,String phoneNum,int gender){

        if(loginService.regist(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    }

}
