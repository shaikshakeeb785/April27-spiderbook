package com.spiderBookWareHouse.BusinessWebsiteService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spiderBookWareHouse.BusinessWebsiteDao.BusinessWebsiteDao;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class ClientServerCommunicationServiceImpl implements ClientServerCommunicationService {
   @Autowired
    private BusinessWebsiteDao businessWebsiteDao;
    @Override
    public void saveClientBookToServer(Book book)
    {
       ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValueAsString(businessWebsiteDao.saveBook(book));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClientBookFromServer(String sellerName) {
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValueAsString(businessWebsiteDao.deleteSellerBook(sellerName));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
