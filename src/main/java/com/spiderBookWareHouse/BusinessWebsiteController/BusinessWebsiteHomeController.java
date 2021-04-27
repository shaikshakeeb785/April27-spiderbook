package com.spiderBookWareHouse.BusinessWebsiteController;

import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import com.spiderBookWareHouse.BusinessWebsiteService.BusinessWebsiteService;
import com.spiderBookWareHouse.CustomValidator.BookCustomValidator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
public class BusinessWebsiteHomeController {

    @Autowired
    private BusinessWebsiteService businessWebsiteService;
    @Autowired
    private BookCustomValidator bookCustomValidator;
    private static final Logger logger = LogManager.getLogger(BusinessWebsiteHomeController.class);

    @RequestMapping("/homepage")
    public String homePage()
    {
        return "homePage";
    }
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(@ModelAttribute Book book , Model model)
    {
        BasicConfigurator.configure();
        logger.info("inside addBook method");
        model.addAttribute("book", book);

        return "addBookPage";
    }
    @RequestMapping(value ="/saveBook", method = RequestMethod.POST)
    public String  saveBook(@ModelAttribute("book")Book book, BindingResult result, Model model) throws IOException
    {
        System.out.println("client to server");
        logger.info("inside saveBook method");

        bookCustomValidator.validate(book, result);
        if (result.hasErrors()) {
            return "addBookPage";
        } else {
            int result1=  businessWebsiteService.saveBook(book);
            if(result1>=1)
            {
                return "redirect:/getAllBooks";
            }else{
                return "error";
            }

        }
    }
    @RequestMapping("getAllBooks")
    public String getAllBook(Model model)
    {
        List<Book> book=businessWebsiteService.getAllBook();
        model.addAttribute("lstBookObject",book);
        return "getAllBooksPage";
    }
    @RequestMapping("/deleteRecordById/{bookId}")
    public String deleteBookById(@PathVariable("bookId") String bookId, Model model)
    {
        logger.info("inside deleteBookById method");
        int result = businessWebsiteService.deleteBookById(bookId);
        if (result >= 1)
        {
            return "redirect:/getAllBooks";
        } else {
            return "errorPage";
        }
    }
    @RequestMapping(value = "/update/{bookId}", method = RequestMethod.GET)
    public String updateRecordById(@PathVariable("bookId") String bookId, Model model)
    {
        logger.info("inside updateRecordById method");
        Book book = businessWebsiteService.getBookById(bookId);
        model.addAttribute("bookObject1", book);

        return "updateBookPage";
    }
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String update(@ModelAttribute("bookObject1") Book book)
    {
        logger.info("inside update method");
        int result = businessWebsiteService.updateBookById(book);
        logger.info("No of record is effected:" + result);
        if (result >= 1) {
            return "redirect:/getAllBooks";
        } else {
            return "errorPage";
        }
    }
}
