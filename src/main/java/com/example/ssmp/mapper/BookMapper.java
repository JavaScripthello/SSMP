package com.example.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmp.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: SSMP
 * @description: 书籍数据层接口
 * @author: kangwei
 * @create: 2022-06-18 10:21
 **/
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
