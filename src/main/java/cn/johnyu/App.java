package cn.johnyu;


import cn.johnyu.dao.BookMapper;
import cn.johnyu.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        List<Book> list=bookMapper.findAllBooks();
        for(Book o:list){
            System.out.println(o.getName()+",,,"+o.getId());
        }

    }
}
