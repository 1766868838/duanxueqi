package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.BorrowMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.UJoinB;
import com.example.demo.pojo.User;
import com.github.yulichang.query.MPJQueryWrapper;

import jakarta.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	private BorrowMapper borrowMapper;
	@Test
	void contextLoads() {

		MPJQueryWrapper<Borrow> wrapper = new MPJQueryWrapper<Borrow>().select("t.borrow_date")
		.select("b.book_name","b.book_type","b.author","b.press")
		.leftJoin("books b on t.book_id = b.id")
		.eq("card_num","2020212205251");

		List<UJoinB> list = borrowMapper.selectJoinList(UJoinB.class,wrapper);
		
		System.out.println(list);
	}

}
