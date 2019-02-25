package com.ww.library.service.Impl;

import com.ww.library.dao.TestDao;
import com.ww.library.entity.Book;
import com.ww.library.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public List<Book> findAllBooks(){
        return testDao.findAllBooks();

    }
}
