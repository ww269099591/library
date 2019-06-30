package com.ww.library.dao;

import com.ww.library.entity.Book;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@CacheNamespace
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> findBooksByKeyWord(String keyword);

    void updateBookCover(Map<String,Object> map);

    String findCoverPathById(Integer bookId);

    List<Book> findAllBooks(/*@Param("start") */Integer start,/*@Param("end")*/ Integer end);

    Integer countBooks();
}