package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Book;
import com.github.yulichang.base.MPJBaseMapper;

/**
 * 图书mapper类，操作数据库
 */
@Mapper
public interface BookMapper extends MPJBaseMapper<Book>{

}
