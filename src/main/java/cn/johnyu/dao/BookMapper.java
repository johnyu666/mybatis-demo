package cn.johnyu.dao;


import cn.johnyu.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
//    @Select("select * from books where id = #{id}")
    Book loadBook(@Param("id") int id);
    List<Book> findAllBooks();
    void addBook(Book book);
    void updateBook(@Param("id") int id, @Param("book") Book book);
}
