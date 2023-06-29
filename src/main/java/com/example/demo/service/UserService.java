package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    /* public boolean addReader(String cardNum,String username,String password,String phoneNum,int gender){
        
        try {
            password = PasswordToKey.main(password);
            User user = new User(username,password,cardNum,phoneNum,gender,0);
            userMapper.insert(user);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    } */
    public boolean addReader(User user){
        
        try {
            user.setPassword(PasswordToKey.main(user.getPassword()));
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
    public boolean addManager(String cardNum,String username,String password,String phoneNum,int gender){
        
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

    /**
     * 查询读者信息
     * @return
     */
    public List<User> selectReader(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("identity_type",1);//小于等于1代表读者
        return userMapper.selectList(queryWrapper);
    }

    /**
     * 查询图书管理员信息
     * @return
     */
    public List<User> selectManager(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("identity_type",2);//等于2代表图书管理员
        return userMapper.selectList(queryWrapper);
    }

    public User selectOne(String cardNum){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("card_num",cardNum);//小于等于1代表读者
        return userMapper.selectOne(queryWrapper);
    }

    public boolean updateOne(User user){
        try {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("card_num", user.getCardNum().toString());
            userMapper.update(user, updateWrapper);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public boolean updateManager(int id,String name){
        try {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("card_num", id);
            User user = userMapper.selectOne(updateWrapper);
            user.setUsername(name);
            userMapper.updateById(user);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public boolean deleteById(String id){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("card_num", id);
            userMapper.delete(queryWrapper);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }      
    }
}
