package com.spiderBookWareHouse.MarshalingUnMarshlingService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ObjectToXmlAndXmlToObjectConvertersImpl implements ObjectToXmlAndXmlToObjectConverters
{
    private static final Logger logger = LogManager.getLogger(ObjectToXmlAndXmlToObjectConvertersImpl.class);

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public ObjectToXmlAndXmlToObjectConvertersImpl() {}
    public ObjectToXmlAndXmlToObjectConvertersImpl(Marshaller marshaller, Unmarshaller unmarshaller)
    {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }
    @Override
    public String convertObjectToXml(Object object)
    {
        logger.info("Exception handling using try and catchBlock");
        StringWriter stringWriter = new StringWriter();
        try {
            marshaller.marshal(object,new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (IOException e) {
            System.out.println("Exception" + e);
        }
        return null;
    }
    @Override
    public Object convertXmlToObject(String XmlString)
    {
        StringReader stringReader=new StringReader(XmlString);
        StreamSource streamSource=new StreamSource(stringReader);
        logger.info("Exception handling using try and catchBlock");
        try{
            return unmarshaller.unmarshal(streamSource);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
