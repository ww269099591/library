package com.ww.library.service;

import com.ww.library.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    /**
     * 根据关键字搜索书籍
     *
     * @param
     * @param
     * @return
     */
    List<Book> findBooksByKeyWord(String keyword);
    /**
     * 更新数据库书封面路径
     *
     * @param
     * @param
     * @return
     */
    void updateBookCover(String coverPath,Integer id);
    /**
     * 更新书封面
     *
     * @param
     * @param
     * @return
     */
    String saveCover(Integer bookId,MultipartFile file,String path);

    String findCoverPathById(Integer bookId);

    List<Book> findAllBooks(Integer start,Integer pageSize);

    Integer countBooks();


}
