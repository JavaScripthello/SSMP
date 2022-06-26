package com.example.ssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.entity.Book;
import com.example.ssmp.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmpApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectById() {
        Book book = bookMapper.selectById(1);
        System.out.println("book ==>"+book);
    }
    @Test
    void insert() {
        Book book = new Book();
        book.setBookAuthor("马晓佳");
        book.setBookName("乌合之众");
       bookMapper.insert(book);
    }

    @Test
    void bookByPage(){
        IPage page = new Page(1,2);
        bookMapper.selectPage(page,null);
    }

    @Test
    void bookQueryByCondition(){
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<Book>();
        queryWrapper.like(Book::getBookName,"乌合之众");
        bookMapper.selectOne(queryWrapper);
    }



}
