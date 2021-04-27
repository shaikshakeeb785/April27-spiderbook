package com.spiderBookWareHouse.BusinessWebsiteService;

import com.spiderBookWareHouse.BusinessWebsiteDto.Book;

public interface ClientServerCommunicationService
{
    public void saveClientBookToServer(Book book);
    public void deleteClientBookFromServer(String sellerName);
}
