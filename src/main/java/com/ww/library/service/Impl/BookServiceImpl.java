package com.ww.library.service.Impl;

import com.ww.library.dao.BookDao;
import com.ww.library.dao.TestDao;
import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import com.ww.library.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findBooksByKeyWord(String keyword) {
        return bookDao.findBooksByKeyWord(keyword);
    }
}
