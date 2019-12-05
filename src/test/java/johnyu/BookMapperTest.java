package johnyu;

import cn.johnyu.dao.BookMapper;
import cn.johnyu.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class BookMapperTest {

    private SqlSession session;
    private BookMapper bookMapper;
    @Before
    public void start() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session=sqlSessionFactory.openSession(true);
        bookMapper = session.getMapper(BookMapper.class);
    }

    @After
    public void end(){
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Book> books=bookMapper.findAllBooks();

        books.forEach(book->{
            System.out.println(book.getName()+"\t"+book.getId());
        });
    }
    @Test
    public void testAdd() throws Exception{
        Book book=new Book();
        book.setName("book1");

        bookMapper.addBook(book);
//        session.commit();
    }
    @Test
    public void testUpdate() throws Exception{
        Book book=new Book();
        book.setId(1);
        book.setName("mikeliu");
        bookMapper.updateBook(1,book);
    }
}
