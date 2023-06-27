package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.pojo.User;

import jakarta.annotation.Resource;

/**
 * 用户控制类
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加读者
     * @return
     */
    @RequestMapping("/addReader")
    public boolean addReader(String cardNum,String username,String password,String phoneNum,int gender){

        if(userService.addReader(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    }

    @RequestMapping("/addManager")
    public boolean addManager(String cardNum,String username,String password,String phoneNum,int gender){

        if(userService.addReader(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    }

    @RequestMapping("selectReader")
    public List<User> selectReader(){
        return userService.selectReader();
    }

    @RequestMapping("selectManager")
    public List<User> selectManager(){
        return userService.selectManager();
    }
}
