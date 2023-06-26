package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;

import jakarta.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 书籍控制类
 */
@RestController
@RequestMapping("book")
public class BookController {
    
    @Resource
    private BookService bookService;

    /**
     * 添加图书
     * @param id
     * @param book_name
     * @param book_type
     * @param author
     * @param price
     * @param language
     * @param press
     * @param publication_date
     * @param introduce
     * @param is_borrow
     * @return
     */
    @RequestMapping("addBook")
    public boolean addBook(Integer id,String book_name,String book_type,
    String author,float price,String language,String press,String publication_date,
    String introduce,int is_borrow){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date publicationDate;
        try {
            publicationDate = format.parse(publication_date);
            if(bookService.addBook(id,book_name,book_type,author,price,language,press,publicationDate,introduce,is_borrow)){
                return true;
            }
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
  
    }
    
    @RequestMapping("deleteById")
    public boolean deleteById(Integer id){
        if(bookService.deleteById(id)) return true;
        return false;
    }
}
