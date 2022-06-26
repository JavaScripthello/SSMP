package com.example.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ssmp.entity.Book;

/**
 * @program: SSMP
 * @description: 数据业务逻辑接口层
 * @author: kangwei
 * @create: 2022-06-18 16:03
 **/
public interface IBookService extends IService<Book> {
    IPage getPage(Integer currentPage, Integer pageSize, String params);

    IPage getPage(String params);
}
