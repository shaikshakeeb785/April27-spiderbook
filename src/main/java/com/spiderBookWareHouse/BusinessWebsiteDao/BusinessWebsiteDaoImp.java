package com.spiderBookWareHouse.BusinessWebsiteDao;

import com.spiderBookWareHouse.BusinessWebsiteController.MyRowMapper;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class BusinessWebsiteDaoImp implements BusinessWebsiteDao
{
    private static final Logger logger = LogManager.getLogger(BusinessWebsiteDaoImp.class);
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveBook(Book book)
    {
        String query = "insert into book(bookId,bookName,bookAuthor,bookPrice,bookPublishDate,sellerName,publication) values(?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookPublishDate(), book.getSellerName(), book.getPublication());
        logger.info(" value of i:" + result);

        return result;
    }
    @Override
    public List<Book> getAllBook()
    {
        logger.info("get All Record ");
        String query = "select * from book";
        List<Book> listBook = this.jdbcTemplate.query(query, new MyRowMapper());

        return listBook;
    }
    @Override
    public Book getBookById(String BookId)
    {
        logger.info("Getting Single Record by BookId:" + BookId);
        String query = "select * from book where bookId=?";
        Book book = (Book) this.jdbcTemplate.queryForObject(query, new MyRowMapper(), BookId);

        return book;
    }
    @Override
    public int deleteBookById(String BookId)
    {
        logger.info("Delete Record By Id ");
        String query = "delete from book where bookId=?";
        int result = this.jdbcTemplate.update(query, BookId);

        return result;
    }
    @Override
    public int updateBookById(Book book)
    {
        logger.info("Updating Book By BookId ");
        String query="update book set bookName=?,bookAuthor=?,bookPrice=?,bookPublishDate=?,sellerName=?,publication=? where bookId=?";
        return this.jdbcTemplate.update(query,book.getBookName(),book.getBookAuthor(),book.getBookPrice(),book.getBookPublishDate(),book.getSellerName(),book.getPublication(),book.getBookId());
    }

    @Override
    public int deleteSellerBook(String sellerName) {
        logger.info("Delete Record By Id ");
        String query = "delete from book where sellerName=?";
        int result = this.jdbcTemplate.update(query, sellerName);

        return result;
    }

    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
}
