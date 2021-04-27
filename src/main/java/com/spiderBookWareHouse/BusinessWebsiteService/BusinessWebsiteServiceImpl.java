package com.spiderBookWareHouse.BusinessWebsiteService;
import com.spiderBookWareHouse.BusinessWebsiteDao.BusinessWebsiteDao;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import java.util.List;
import java.util.Random;

public class BusinessWebsiteServiceImpl implements BusinessWebsiteService
{
    private static final Logger logger = LogManager.getLogger(BusinessWebsiteServiceImpl.class);

    private BusinessWebsiteDao businessWebsiteDao;
    @Override
    public int saveBook(Book book)
    {
        logger.info("Inside saveBook Method");
        BasicConfigurator.configure();
        Random random=new Random();
        int number=random.nextInt();
        String bookId="spiderBookId_"+number;
        book.setBookId(bookId);
        int result=businessWebsiteDao.saveBook(book);

        return result;
    }
    @Override
    public List<Book> getAllBook()
    {
        logger.info("Inside getAllBook Method");
       List<Book> lstbook= businessWebsiteDao.getAllBook();

        return lstbook;
    }
    @Override
    public Book getBookById(String BookId)
    {
        logger.info("Inside getBookById Method");
        Book book=businessWebsiteDao.getBookById(BookId);

        return book;
    }
    @Override
    public int deleteBookById(String BookId)
    {
        logger.info("Inside deleteBookById Method");
        int result=businessWebsiteDao.deleteBookById(BookId);

        return result;
    }
    @Override
    public int updateBookById(Book book)
    {
        logger.info("Inside updateBookById Method");
       int result= businessWebsiteDao.updateBookById(book);

        return result;
    }

    @Override
    public int deleteSellerBook(String emailId) {

        return 0;
    }

    public BusinessWebsiteDao getBusinessWebsiteDao()
    {
        return businessWebsiteDao;
    }
    @Required
    public void setBusinessWebsiteDao(BusinessWebsiteDao businessWebsiteDao)
    {
        this.businessWebsiteDao = businessWebsiteDao;
    }
}
