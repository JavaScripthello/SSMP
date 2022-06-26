package com.example.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ssmp.entity.Book;
import com.example.ssmp.service.IBookService;
import com.example.ssmp.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.jsf.FacesContextUtils;

import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;
import java.util.List;


/**
 * @program: SSMP
 * @description: 书籍控制层
 * @author: kangwei
 * @create: 2022-06-18 16:42
 **/
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public ResultUtils getBooks() {
        List<Book> books = iBookService.list();
        boolean emptyBooks = CollectionUtils.isEmpty(books);
        return new ResultUtils(emptyBooks, emptyBooks ? "查询失败" : "查询成功", books);
    }

    @PostMapping
    public ResultUtils save(@RequestBody Book book) {
        log.info("添加书籍请求入参 ==>"+book);
        boolean saveFlag = iBookService.save(book);

        return new ResultUtils(saveFlag, saveFlag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public ResultUtils update(@RequestBody Book book) {
        boolean updateFlag = iBookService.saveOrUpdate(book);
        return new ResultUtils(updateFlag, updateFlag ? "修改成功" : "修改失败");
    }

    @DeleteMapping("/{bookId}")
    public ResultUtils delete(@PathVariable Integer bookId) {
        boolean removeFlag = iBookService.removeById(bookId);
        return new ResultUtils(removeFlag, removeFlag ? "删除成功" : "删除失败");
    }


    @GetMapping("/{bookId}")
    public ResultUtils getBookById(@PathVariable("bookId") Integer bookId) {
        Book book = iBookService.getById(bookId);
        boolean emptyFlag = ObjectUtils.isEmpty(book);

        return new ResultUtils(emptyFlag, emptyFlag ? "查询失败" : "查询成功", book);
    }

    @PostMapping("/getPage")
    public ResultUtils getBooksByPage(@RequestBody String params) {
        System.out.println(params+"---");
        IPage page = iBookService.getPage(params);
        System.out.println(page);
        return new ResultUtils(true, page);
    }


}
