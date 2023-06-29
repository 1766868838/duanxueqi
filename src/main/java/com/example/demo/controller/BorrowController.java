package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.UJoinB;
import com.example.demo.pojo.User;
import com.example.demo.service.BorrowService;
import com.example.demo.service.UserService;

import jakarta.annotation.Resource;

/**
 * 借阅控制类
 */
@RestController
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @Resource
    private UserService userService;

    /* @RequestMapping("borrow")
    public boolean borrow(@RequestBody Borrow borrow){
        if(borrowService.borrow(borrow)) return true;
        return false;
    } */

    @RequestMapping("borrow")
    @ResponseBody
    public int borrow(@RequestBody JSONObject body){
        try {
            System.out.println(body);
            JSONArray books = body.getJSONArray("book");
            String cardName = body.getString("cardNum");


            
            if(cardName.equals("2020212205258")){
                return 3;
            }

            //借书超过上限
            User user = userService.selectOne(cardName);
            int canBorrow = user.getIdentity() * 5 + 10 - user.getBorrowing() - books.size();
            System.out.println(canBorrow+"sdfsdfdsfdsfsdfsdfdsfsdfsdfsdfsdfsdf");
            if(canBorrow < 0 ) return 2;

            //可借书，调用借书服务
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.print(books.size());

            for(int i=0;i<books.size();i++) {
                JSONObject book = books.getJSONObject(i);
                borrowService.borrow(new Borrow(book.getString("bookName"),book.getInteger("id"),
                cardName,timestamp));
                System.out.println(books.getJSONObject(i).get("bID"));
            }  
            return 1;
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
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

    @RequestMapping("returnBook")
    public User returnBook(@RequestBody Borrow borrow){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        borrow.setReturnDate(timestamp);
        
        
        if(borrowService.returnBook(borrow)) return userService.selectOne(borrow.getCardNum());
        return null;
    }
}
