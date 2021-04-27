package com.spiderBookWareHouse.BusinessWebsiteController;

import com.spiderBookWareHouse.BusinessWebsiteDao.BusinessWebsiteDao;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
@Controller
public class ConvertAllBooksDataToJson
{
    private static final Logger logger = LogManager.getLogger(ConvertAllBooksDataToJson.class);
    @Autowired
    private BusinessWebsiteDao businessWebsiteDao;

    @RequestMapping("/getAllBooksjson")
    @ResponseBody
    public String getAllBookDataToJson()
    {
        BasicConfigurator.configure();
        List<Book> book=businessWebsiteDao.getAllBook();
        logger.info("by using ObjectMapper object values is converting into json form");
        ObjectMapper mapper=new ObjectMapper();
        try{
            logger.info("Exception handling using try and catch block");
           return mapper.writeValueAsString(book);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    @RequestMapping("/getByIdjsondata")
    @ResponseBody
    public String getByIdJsonData(@RequestParam("bookId") String bookId)
    {
        logger.info("by using ObjectMapper object values is converting into json form");
        ObjectMapper mapper=new ObjectMapper();
        try{
            return mapper.writeValueAsString(businessWebsiteDao.getBookById(bookId));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
