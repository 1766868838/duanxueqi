package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Borrow;
import com.github.yulichang.base.MPJBaseMapper;

/**
 * 借阅mapper类，操作数据库
 */
@Mapper
public interface BorrowMapper extends MPJBaseMapper<Borrow>{
    
}
