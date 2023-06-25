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
    public boolean login(Double cardNum,String password){
        try {
            QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
            queryWrapper.eq("card_num",cardNum);
            User user = userMapper.selectOne(queryWrapper);

            //解密
            byte[] salt = new byte[16];
            salt = PasswordToKey.hexStringToBytes(user.getPassword().substring(0, 32));

            String newKey = PasswordToKey.decrypt(password,salt);
            String oldKey = user.getPassword();
            if(newKey.equals(oldKey)){
                //密码正确，登录界面
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public boolean regist(Double cardNum,String username,String password,String phoneNum,int gender){
        
        try {
            password = PasswordToKey.main(password);
            User user2 = new User(username,password,cardNum,phoneNum,gender);
            userMapper.insert(user2);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
}
