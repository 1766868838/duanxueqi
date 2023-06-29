package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.pojo.User;

import jakarta.annotation.Resource;

/**
 * 用户控制类
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加读者
     * @return
     */
    @RequestMapping("addReader")
    /* public boolean addReader(String cardNum,String username,String password,String phoneNum,int gender){

        if(userService.addReader(cardNum, username, password, phoneNum, gender)){
            return true;
        }
        return false;
    } */
    public boolean addReader(@RequestBody User user){

        if(userService.addReader(user)){
            return true;
        }
        return false;
    }

    @RequestMapping("addManager")
    public boolean addManager(@RequestBody User user){

        if(userService.addReader(user)){
            return true;
        }
        return false;
    }


    /**
     * 查找所有读者
     * @return
     */
    @RequestMapping("selectReader")
    public List<User> selectReader(){
        return userService.selectReader();
    }

    /**
     * 查找所有管理员
     * @return
     */
    @RequestMapping("selectManager")
    public List<User> selectManager(){
        return userService.selectManager();
    }

    /**
     * 查找指定的用户
     * @param cardNum
     * @return
     */
    @RequestMapping("selectOne")
    public User selectOne(String cardNum){
        return userService.selectOne(cardNum);
    }


    @RequestMapping("update")
    public boolean updateUser(@RequestBody User user){
        return userService.updateOne(user);
    }
}
