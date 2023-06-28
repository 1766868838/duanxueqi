package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
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
    public User login(double card_num,String password,int identity_type){
        try {
            return loginService.login(card_num, password,identity_type);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return null;
        }

    }

}
