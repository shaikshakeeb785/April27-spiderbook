package com.spiderBookWareHouse.MarshalingUnMarshlingService;

public interface ObjectToXmlAndXmlToObjectConverters
{
    /**
     * @param object here we passing a Reges Object to this method which converted into xmlString Object
     * @return it return  xmlString  object
     */
    public String convertObjectToXml(Object object);
    /**
     * @param XmlString here we passing a xmlString object to this method which is converted into Object
     * @return it return Object
     */
    public Object convertXmlToObject(String XmlString);
}
