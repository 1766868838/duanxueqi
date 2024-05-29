package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.utils.PasswordToKey;
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
     * @return 结果标记
     */
    @RequestMapping("addReader")
    public boolean addReader(@RequestBody User user){

        if(userService.addReader(user)){
            return true;
        }
        return false;
    }

    /**
     * 添加管理员
     * @param user 用户
     * @return 结果
     */
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
        user.setPassword(PasswordToKey.main(user.getPassword()));
        return userService.updateOne(user);
    }

    @RequestMapping("updateManager")
    public boolean updateManager(int id , String name){
        return userService.updateManager(id,name);
    }

    @RequestMapping("deleteById")
    public boolean deleteById(String cardNum){

        System.out.println(cardNum);
        if(userService.deleteById(cardNum)) return true;
        return false;
    }
}
