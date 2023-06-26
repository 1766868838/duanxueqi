package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book>{
    
}
