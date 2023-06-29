package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.Book;

import jakarta.annotation.Resource;

@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;

    /**
     * 增加图书
     * @param id
     * @param book_name
     * @param book_type
     * @param author
     * @param price
     * @param language
     * @param press
     * @param publication_data
     * @param introduce
     * @param is_borrow
     * @return
     */
    /* public boolean addBook(Integer id, String book_name, String book_type,
     String author, float price, String language, String press,
      Date publication_date, String introduce,int is_borrow){
        try {
            Book book = new Book(id,book_name,book_type,author,price,language,press,publication_date,introduce,is_borrow);
            bookMapper.insert(book);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    } */

    public boolean addBook(Book book){
        try {
            bookMapper.insert(book);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 通过id删除指定图书
     * @param id
     * @return
     */
    public boolean deleteById(Integer id){
        try {
            bookMapper.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }      
    }

    /**
     * 修改图书信息
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
     * @return 是否成功
     */
    public boolean update(Book book){
        try {
            bookMapper.updateById(book);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    /* public boolean update(Integer id, String book_name, String book_type,
     String author, float price, String language, String press,
      Date publication_date, String introduce,int is_borrow){

        try {
            Book book = new Book(id,book_name,book_type,author,price,language,press,publication_date,introduce,is_borrow);
            bookMapper.updateById(book);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    } */

    /**
     * 查找所有书
     * @return list 书的列表
     */
    public List<Book> select(){
        List<Book> list = bookMapper.selectList(null);
        return list;
    }

    /**
     * 查找没被借的书
     * @return list 图书列表
     */
    public List<Book> selectUn(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq( "is_borrow", 0);
        List<Book> list = bookMapper.selectList(queryWrapper);
        return list;
    }
}
