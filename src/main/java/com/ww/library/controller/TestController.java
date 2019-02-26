package com.ww.library.controller;

import com.ww.library.dao.TestDao;
import com.ww.library.entity.Book;
import com.ww.library.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("Test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("findAllBooks")
    @ResponseBody
    public List<Book> findAllBooks(){
        return testService.findAllBooks();
    }
    @RequestMapping("test")
    @ResponseBody
    public ModelAndView findBook(){
        List<Book> books=testService.findAllBooks();
        ModelAndView view =new ModelAndView("index");
        view.addObject("books",books);
        return view;
    }




}
