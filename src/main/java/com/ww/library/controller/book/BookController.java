package com.ww.library.controller.book;

import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("Book")
@RequestMapping("Book")

public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("findBooksByKeyWord")
    @ResponseBody
    public ModelAndView findBooksByKeyWord(String keyword){
        List<Book> books=bookService.findBooksByKeyWord(keyword);
        ModelAndView view =new ModelAndView("index");
        view.addObject("books",books);
        return view;
    }
}
