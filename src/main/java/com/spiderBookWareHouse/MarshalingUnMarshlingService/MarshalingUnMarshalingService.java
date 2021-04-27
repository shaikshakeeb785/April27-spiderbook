package com.spiderBookWareHouse.MarshalingUnMarshlingService;

public interface MarshalingUnMarshalingService
{

 /** converting object to xml
  * @return StringXml data
  */
 public String convertObjectToXml();

 /**
  * @param XmlString this parameter is used to conver xmlString data to object
  * @return Object
  */
 public Object convertXmlToObject(String XmlString);

}
