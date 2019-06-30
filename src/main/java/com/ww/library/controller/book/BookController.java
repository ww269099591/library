package com.ww.library.controller.book;


import com.alibaba.fastjson.JSONObject;
import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("Book")
@RequestMapping("Book")
public class BookController {
    @Autowired
    BookService bookService;

    @Value("${filePath}")
    private String filePath;

    private RabbitTemplate rabbitTemplate;


    @RequestMapping("toIndex")
    public String ToIndex() {
        return "index";
    }

    @RequestMapping("findBooksByKeyWord")
    @ResponseBody
    public ModelAndView findBooksByKeyWord(String keyword) {
        ModelAndView view = new ModelAndView("index");
        if (keyword == null) {
            view.addObject("result", "fail");
            return view;
        }
        List<Book> books = bookService.findBooksByKeyWord(keyword);

        List<Book> books2= bookService.findBooksByKeyWord(keyword);
        view.addObject("result", "success");
        view.addObject("books", books);
        return view;
    }

    @RequestMapping("updateBookCover")
    @ResponseBody
    public String updateBookCover(HttpServletRequest request, MultipartFile file, Integer bookId) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        if (bookId == null) {
            return "书本id为空";
        }
        String result = bookService.saveCover(bookId, file, filePath);
        return result;
    }

    @RequestMapping("toSaveBooks")
    public String toSaveBooks() {
        return "SaveBooks";
    }

    @RequestMapping("ajaxFindAllBooks")
    @ResponseBody
    public String ajaxFindBooksByKeyWord(Integer start) {
        JSONObject result = new JSONObject();
        Integer pageSize = 10;
        List<Book> books = bookService.findAllBooks(start, pageSize);
        result.put("books", books);
        System.out.println(result.toJSONString());
        return result.toString();
    }


    @RequestMapping("findAllBooks")
    @ResponseBody
    public ModelAndView findAllBooks() {
        Integer start=0;
        Integer pageSize = 10;
        ModelAndView mv = new ModelAndView("ShowBooks");
        Integer count = bookService.countBooks();
        List<Book> books = bookService.findAllBooks(start, pageSize);
        Integer totalPages=count / pageSize + 1;
        Integer presentPage=start/pageSize;
        mv.addObject("presentPage",presentPage);
        mv.addObject("firstPage",presentPage-5<1?1:presentPage-5);
        mv.addObject("lastPage",presentPage+5>totalPages?totalPages:presentPage+5);
        mv.addObject("books", books);
        return mv;
    }

    @RequestMapping("mqTest")
    public void mqTest(){

    }
}
