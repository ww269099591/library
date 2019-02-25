package com.ww.library.dao;

import com.ww.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TestDao {
    List<Book> findAllBooks();

}
