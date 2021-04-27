package com.spiderBookWareHouse.BusinessWebsiteService;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BusinessWebsiteService
{
    /**
     * @param book it is Book object to save into the database
     * @return this save method returns Book object which  saved in database.
     */
    public int saveBook(Book book);

    /**
     * @return this method returns List of Books which is saved in database.
     */
    public List<Book> getAllBook();

    /**
     * @param BookId this parameter is BookId to getParticular record from the database.
     * @return returns a particular Book based on bookid.
     */
    public Book getBookById(String BookId);

    /**
     * @param BookId this parameter is used for deleting the record from the database.
     * @return return no of record is effected.
     */
    public int deleteBookById(String BookId);


    /**
     * @param book it is updated object which is store in database
     * @return no of effected row
     */
    public int updateBookById(Book book);

    /**delete seller book by seller id/emailId
     * @param emailId
     * @return no of record is effected
     */
    public int deleteSellerBook(String emailId);
}
