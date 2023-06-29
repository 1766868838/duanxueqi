package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.UJoinB;
import com.example.demo.service.BorrowService;

import jakarta.annotation.Resource;
import net.sf.jsqlparser.expression.TimestampValue;

/**
 * 借阅控制类
 */
@RestController
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    /* @RequestMapping("borrow")
    public boolean borrow(@RequestBody Borrow borrow){
        if(borrowService.borrow(borrow)) return true;
        return false;
    } */

    @RequestMapping("borrow")
    @ResponseBody
    public boolean borrow(@RequestBody JSONObject body){
        try {
            JSONArray books = body.getJSONArray("book");
            String cardName = body.getString("card_num");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            for(int i=0;i<books.size();i++) {
                JSONObject book = books.getJSONObject(i);
                borrowService.borrow(new Borrow(book.getString("Bname"),book.getInteger("bID"),
                cardName,timestamp));
                System.out.println(books.getJSONObject(i).get("bID"));
            }
            return true;
        } catch (Exception e) {
            return false;
        }        
    }

    @RequestMapping("selectOneBorrow")
    public List<UJoinB> selectOneBorrow(String card_num){
        return borrowService.selectOneBorrow(card_num);
    }

    @RequestMapping("selectBorrow")
    public List<Borrow> selectBorrow(){
        return borrowService.selectBorrow();
    }
    /* public boolean borrow(String book_name,int book_id,double card_num,String borrow_name,
    String borrow_date,String return_date,String return_type){
        Timestamp borrowDate = Timestamp.valueOf(borrow_date);
        Timestamp returnDate = Timestamp.valueOf(return_date);
        if(borrowService.borrow(book_name,book_id,card_num,borrow_name,borrowDate,returnDate,return_type)) return true;
        return false;
    } */
}
