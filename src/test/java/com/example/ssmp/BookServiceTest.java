package com.example.ssmp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.entity.Book;
import com.example.ssmp.service.IBookService;
import com.example.ssmp.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @program: SSMP
 * @description: test
 * @author: kangwei
 * @create: 2022-06-18 16:12
 **/
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService iBookService;
    @Test
    void getAll(){
        Map<String, Object> map = iBookService.getMap(null);
        List<Book> books = iBookService.list();
        System.out.println(books);
    }
    @Test
    void getBookByPage(){
        IPage page = new Page(1,2);
        iBookService.page(page,null);
        long pages = page.getPages();
        List records = page.getRecords();
    }
}
