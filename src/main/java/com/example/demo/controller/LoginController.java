package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;

import jakarta.annotation.Resource;

/**
 * 登录控制类
 */
@Controller

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
    public boolean login(String username,String password){
        


        return false;
    }

}
