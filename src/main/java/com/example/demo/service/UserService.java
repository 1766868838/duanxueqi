package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.utils.PasswordToKey;

import jakarta.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 添加读者
     * @param username
     * @param password
     * @return
     */
    public boolean addReader(Double cardNum,String username,String password,String phoneNum,int gender){
        
        try {
            password = PasswordToKey.main(password);
            User user = new User(username,password,cardNum,phoneNum,gender,0);
            userMapper.insert(user);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }

    /**
     * 添加管理员
     * @param cardNum
     * @param username
     * @param password
     * @param phoneNum
     * @param gender
     * @return
     */
    public boolean addManager(Double cardNum,String username,String password,String phoneNum,int gender){
        
        try {
            password = PasswordToKey.main(password);
            User user = new User(username,password,cardNum,phoneNum,gender,2);
            userMapper.insert(user);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
}
