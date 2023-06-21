package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;

/**
 * 读者mapper类，操作数据库
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

}