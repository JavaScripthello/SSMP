package com.example.ssmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: SSMP
 * @description: 书籍实体类
 * @author: kangwei
 * @create: 2022-06-18 10:20
 **/
@Data
@TableName("bookdto")
public class Book {
//    @TableField("book_id")
    @TableId(type = IdType.AUTO)
    private String bookId;
    private String bookName;
    private String bookAuthor;
}
