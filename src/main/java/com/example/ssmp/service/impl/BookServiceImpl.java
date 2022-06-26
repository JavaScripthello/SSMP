package com.example.ssmp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ssmp.entity.Book;
import com.example.ssmp.mapper.BookMapper;
import com.example.ssmp.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: SSMP
 * @description: 数据业务逻辑实现层
 * @author: kangwei
 * @create: 2022-06-18 16:04
 **/

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Override
    public IPage getPage(Integer currentPage, Integer pageSize, String params) {
        //
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<Book>();
        JSONObject json = JSONObject.parseObject(params);
        String bookName = json.getString("bookName");
        String bookAuthor = json.getString("bookAuthor");
        if (!StringUtils.isEmpty(bookName)){
            queryWrapper.like(Book::getBookName,bookName);
        }
        if (!StringUtils.isEmpty(bookAuthor)){
            queryWrapper.like(Book::getBookAuthor,bookAuthor);
        }
        IPage page = new Page(currentPage, pageSize);

        IPage page1 = this.page(page, queryWrapper);
        if (currentPage > page1.getPages()) {
            page = new Page((int) page1.getPages(), pageSize);
             page1 = this.page(page, queryWrapper);
        }
        return page1;
    }

    @Override
    public IPage getPage(String params) {
        //
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<Book>();
        if (StringUtils.isEmpty(params)){
            return null;
        }
        JSONObject json = JSONObject.parseObject(params);
        System.out.println(json);
         json = JSONObject.parseObject(json.getString("params"));
        String bookName = json.getString("bookName");
        String bookAuthor = json.getString("bookAuthor");
        Integer pageSize = json.getInteger("pageSize");
        Integer currentPage = json.getInteger("currentPage");
        if (!StringUtils.isEmpty(bookName)){
            queryWrapper.like(Book::getBookName,bookName);
        }
        if (!StringUtils.isEmpty(bookAuthor)){
            queryWrapper.like(Book::getBookAuthor,bookAuthor);
        }
        IPage page = new Page(currentPage, pageSize);

        IPage page1 = this.page(page, queryWrapper);
        if (currentPage > page1.getPages()) {
            page = new Page((int) page1.getPages(), pageSize);
            page1 = this.page(page, queryWrapper);
        }
        return page1;
    }
}
