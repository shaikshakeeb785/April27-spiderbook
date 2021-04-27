package com.spiderBookWareHouse.MarshalingUnMarshlingService;

import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import com.spiderBookWareHouse.BusinessWebsiteDto.BookList;
import com.spiderBookWareHouse.BusinessWebsiteService.BusinessWebsiteService;
import org.springframework.beans.factory.annotation.Required;
import java.util.ArrayList;
import java.util.List;

public class MarshalingUnmarshlingServiceImpl implements MarshalingUnMarshalingService
{
    private ObjectToXmlAndXmlToObjectConverters marshalingUnMarshaling;
    private BusinessWebsiteService businessWebsiteService;

    @Override
    public String convertObjectToXml()
    {
        List<Book> lstbook=businessWebsiteService.getAllBook();
        BookList bookList=new BookList();
        bookList.setLstBook(new ArrayList<Book>(businessWebsiteService.getAllBook()));

        return marshalingUnMarshaling.convertObjectToXml(bookList);
    }
    @Override
    public Object convertXmlToObject(String XmlString)
    {
        return marshalingUnMarshaling.convertXmlToObject(XmlString);
    }
                      /*setter getter method*/
    public BusinessWebsiteService getBusinessWebsiteService()
    {
        return businessWebsiteService;
    }
    @Required
    public void setBusinessWebsiteService(BusinessWebsiteService businessWebsiteService)
    {
        this.businessWebsiteService = businessWebsiteService;
    }
    public ObjectToXmlAndXmlToObjectConverters getMarshalingUnMarshaling()
    {
        return marshalingUnMarshaling;
    }
    @Required
    public void setMarshalingUnMarshaling(ObjectToXmlAndXmlToObjectConverters marshalingUnMarshaling)
    {
        this.marshalingUnMarshaling = marshalingUnMarshaling;
    }
}
