package com.spiderBookWareHouse.BusinessWebsiteController;
import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import com.spiderBookWareHouse.BusinessWebsiteService.ClientServerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ClientServerCommunicationController
{
    @Autowired
     private ClientServerCommunicationService clientServerCommunicationService;

    @RequestMapping(value = "/clientBookObject",method = RequestMethod.POST)
    @ResponseBody
    public void saveClientBookToServer(@RequestBody Book book)
    {
       clientServerCommunicationService.saveClientBookToServer(book);

    }
    @RequestMapping(value = "/deleteClientBook")
    @ResponseBody
    public void deleteClientBookFromServer(@RequestBody String sellerName)
    {
        System.out.println("HEY I AM INSIDE deleteClientBookFromServer");
        clientServerCommunicationService.deleteClientBookFromServer(sellerName);
    }

}
