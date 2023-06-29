package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Book;
import com.example.demo.service.BookService;

import jakarta.annotation.Resource;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
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
    /* @RequestMapping("addBook")
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
    } */

    @RequestMapping("addBook")
    public boolean addBook(@RequestBody Book book){
        System.out.println(book);
        try {
            if(bookService.addBook(book)){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @RequestMapping("deleteById")
    public boolean deleteById(Integer id){
        if(bookService.deleteById(id)) return true;
        return false;
    }

    @RequestMapping("update")
    public boolean update(@RequestBody Book book){
        System.out.println(book);
        try {
            if(bookService.update(book)){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /* public boolean update(Integer id,String book_name,String book_type,
    String author,float price,String language,String press,String publication_date,
    String introduce,int is_borrow){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date publicationDate;
        try {
            publicationDate = format.parse(publication_date);
            if(bookService.update(id,book_name,book_type,author,price,language,press,publicationDate,introduce,is_borrow)){
                return true;
            }
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    } */

    /**
     * 查找所有图书控制类
     * @return List 图书列表
     */
    @RequestMapping("select")
    public List<Book> select(){
        return bookService.select();
    }

    /**
     * 查找未被借走图书的控制类
     * @return List 图书列表
     */
    @RequestMapping("selectUn")
    public List<Book> selectUn(){
        return bookService.selectUn();
    }
}
