package com.ww.library.service.Impl;

import com.ww.library.dao.BookMapper;
import com.ww.library.entity.Book;
import com.ww.library.service.BookService;
import com.ww.library.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookDao;

    @Override
    public List<Book> findBooksByKeyWord(String keyword) {
        return bookDao.findBooksByKeyWord(keyword);
    }

    @Override
    public void updateBookCover(String coverPath, Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("coverPath", coverPath);
        map.put("id", id);
        bookDao.updateBookCover(map);
    }

    @Override
    public String saveCover(Integer bookId, MultipartFile file, String path) {
        String uploadDir = path + "cover/";
        String oldFileName = findCoverPathById(bookId);
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filename = UUID.randomUUID() + suffix;
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + filename);
            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);
            updateBookCover(filename, bookId);
            if(oldFileName!=null) {
                File oldfile = new File(uploadDir + oldFileName);
                if (oldfile.exists() && oldfile.isFile()) {
                    if (oldfile.delete()) {
                        System.out.println("删除单个文件" + oldFileName + "成功！");
                    } else {
                        System.out.println("删除单个文件" + oldFileName + "失败！");
                    }
                } else {
                    System.out.println("删除单个文件失败：" + oldFileName + "不存在！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败图片";
        }
        return "success";
    }
    @Override
    public String findCoverPathById(Integer bookId) {
        String coverPath=bookDao.findCoverPathById(bookId);
        if(Utils.isEmpty(coverPath)){
            return null;
        }
        return coverPath;
    }

    @Override
    public List<Book> findAllBooks(Integer start, Integer pageSize) {
        Integer end=start+pageSize-1;
        return bookDao.findAllBooks(start,end);
    }

    @Override
    public Integer countBooks() {
        return bookDao.countBooks();
    }

}
