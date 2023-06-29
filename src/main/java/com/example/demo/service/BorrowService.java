package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.BorrowMapper;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.UJoinB;
import com.github.yulichang.query.MPJQueryWrapper;
import com.example.demo.pojo.Book;
import jakarta.annotation.Resource;

@Service
public class BorrowService {
    
    @Resource
    private BorrowMapper borrowMapper;

    public boolean borrow(String book_name,int book_id, String card_num, String borrow_name, Timestamp borrow_date, Timestamp return_date, String return_type){
        try {
            Borrow borrow = new Borrow(book_name,book_id,card_num,borrow_name,borrow_date,return_date,return_type);
            borrowMapper.insert(borrow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 借阅图书
     * @param borrow
     * @return
     */
    public boolean borrow(Borrow borrow){
        try {
            borrowMapper.insert(borrow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public List<UJoinB> selectOneBorrow(String card_num){
        try {
            MPJQueryWrapper<Borrow> wrapper = new MPJQueryWrapper<Borrow>().select("t.borrow_date")
                .select("b.book_name","b.book_type","b.author","b.press")
                .leftJoin("books b on t.book_id = b.bid")
                .eq("card_num",card_num);

            List<UJoinB> list = borrowMapper.selectJoinList(UJoinB.class,wrapper);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* public List<UJoinB> selectBorrow(){
        try {
            MPJQueryWrapper<Borrow> wrapper = new MPJQueryWrapper<Borrow>().select("t.borrow_date")
                .select("b.book_name","b.book_type","b.author","b.press")
                .leftJoin("books b on t.book_id = b.bid");

            List<UJoinB> list = borrowMapper.selectJoinList(UJoinB.class,wrapper);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } */

    public List<Borrow> selectBorrow(){
        try {
            List<Borrow> list = borrowMapper.selectList(null);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
