package com.spiderBookWareHouse.MarshalingUnMarshalingController;

import com.spiderBookWareHouse.MarshalingUnMarshlingService.MarshalingUnMarshalingService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class MarshlingUnMarshalingController
{
    @Autowired
    private MarshalingUnMarshalingService marshalingUnMarshalingService;
    private static final Logger logger = LogManager.getLogger(MarshlingUnMarshalingController.class);

    @RequestMapping(value = "/marshaling", produces = {"application/xml"})
    public String convertAllBookDtoToXml(Model model)
    {
        BasicConfigurator.configure();
        String XmlString = marshalingUnMarshalingService.convertObjectToXml();
        model.addAttribute("marshalObject",XmlString);

        return "marshalingPage";
    }
    @RequestMapping(value = "/unmarshaling")
    public Object convertXmlToAllBookDto(Model model) throws IOException
    {
        String XmlString = marshalingUnMarshalingService.convertObjectToXml();
        Object object = marshalingUnMarshalingService.convertXmlToObject(XmlString);
        model.addAttribute("obj",object);
        Path pathXMLFile = Paths.get("C:/Users/Trainee/IdeaProjects/SpiderBookStore/BookData.XML");
        Files.write(pathXMLFile, XmlString.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

         return "unmarshalPage";
    }

}
