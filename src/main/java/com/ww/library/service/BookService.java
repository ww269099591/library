package com.ww.library.service;

import com.ww.library.entity.Book;

import java.util.List;

public interface BookService {
     List<Book> findBooksByKeyWord(String keyword);

}
