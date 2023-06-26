package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

import jakarta.annotation.Resource;

/**
 * 登录控制类
 */
@RestController

public class LoginController {

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

    

}
