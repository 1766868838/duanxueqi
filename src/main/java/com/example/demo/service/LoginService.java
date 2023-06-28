package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.utils.PasswordToKey;

import jakarta.annotation.Resource;

/**
 * 登录业务类
 */
@Service
public class LoginService {
    

    @Resource
    public UserMapper userMapper;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(Double cardNum,String password,int identityType){
        try {
            QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
            queryWrapper.eq("card_num",cardNum);
            User user = userMapper.selectOne(queryWrapper);

            //解密
            byte[] salt = new byte[16];
            salt = PasswordToKey.hexStringToBytes(user.getPassword().substring(0, 32));

            String newKey = PasswordToKey.decrypt(password,salt);
            String oldKey = user.getPassword();
            if(newKey.equals(oldKey)&&identityType==user.getIdentity()){
                //密码正确，登录界面
                return user;
            }
            return null;
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return null;
        }

    }

    
}
