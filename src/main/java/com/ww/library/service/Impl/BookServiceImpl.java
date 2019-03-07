package com.ww.library.service.Impl;

import com.ww.library.dao.BookMapper;
import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookDao;

    @Override
    public List<Book> findBooksByKeyWord(String keyword) {
        return bookDao.findBooksByKeyWord(keyword);
    }
}
