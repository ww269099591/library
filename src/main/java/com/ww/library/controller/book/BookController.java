package com.ww.library.controller.book;

import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import com.ww.library.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller("Book")
@RequestMapping("Book")

public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("findBooksByKeyWord")
    @ResponseBody
    public ModelAndView findBooksByKeyWord(String keyword) {
        List<Book> books = bookService.findBooksByKeyWord(keyword);
        ModelAndView view = new ModelAndView("index");
        view.addObject("books", books);
        return view;
    }

    @RequestMapping("saveBook")
    public String saveBook(HttpServletRequest request, MultipartFile file) {
        String uploadDir = "../cover";
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //上传文件名
            String filename = UUID.randomUUID() + suffix;
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + filename);
            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
