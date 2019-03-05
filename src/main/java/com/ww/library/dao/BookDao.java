package com.ww.library.dao;

import com.ww.library.entity.Book;

import java.util.List;

public interface BookDao {
    //根据一个随便值查找字段
    public List<Book> findBooksByKeyWord(String keyword);
}
