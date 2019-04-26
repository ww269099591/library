package com.ww.library.controller.book;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import com.ww.library.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller("Book")
@RequestMapping("Book")
public class BookController {
    @Autowired
    BookService bookService;

    @Value("${filePath}")
    private String filePath;

    @Value("${wangwei}")
    private String xxx;

    @RequestMapping("findBooksByKeyWord")
    @ResponseBody
    public ModelAndView findBooksByKeyWord(String keyword) {
        ModelAndView view = new ModelAndView("index");
        if(keyword==null){
            view.addObject("result","fail");
            return view;
        }
        List<Book> books = bookService.findBooksByKeyWord(keyword);
        view.addObject("result","success");
        view.addObject("books", books);
/*        JSONObject result=new JSONObject();
        result.put("result","success");
        result.put("books",books);
        System.out.println(view.toString());
        System.out.println(result.toJSONString());
        System.out.println(result.toString());*/
        return view;
    }

    @RequestMapping("updateBookCover")
    @ResponseBody
    public String updateBookCover(HttpServletRequest request, MultipartFile file,Integer bookId) {
        if (file.isEmpty()){
            return "文件为空";
        }
        if(bookId==null){
            return "书本id为空";
        }
        String result=bookService.saveCover(bookId,file,filePath);

        return result;
    }

    @RequestMapping("toSaveBooks")
    public String toSaveBooks()
    {
        return "SaveBooks";
    }
    @RequestMapping("showBooks")
    public ModelAndView showBooks(){
        ModelAndView mv=new ModelAndView("showBooks");
        mv.addObject("imagePath","cover/1d83385d-8c33-4659-b697-e4631ee147a9.jpg");
        return mv;
    }

    @RequestMapping("ajaxFindBooksByKeyWord")
    @ResponseBody
    public String ajaxFindBooksByKeyWord(String keyword){
        JSONObject result=new JSONObject();
        result.put("result","success");
        result.put("book","三只小猪");
        System.out.println(result.toJSONString());
        return result.toString();
    }
    @RequestMapping("toIndex")
    public String ToIndex(){
        return "index";
    }

    @RequestMapping("findAllBooks")
    @ResponseBody
    public ModelAndView findAllBooks(Integer start,Integer pageSize){
           ModelAndView mv=new ModelAndView();

           Integer count =bookService.countBooks();
           List<Book> books= bookService.findAllBooks(start,pageSize);
           return mv;
    }
}
