package com.spiderBookWareHouse.BusinessWebsiteDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList
{
    @XmlElement
    private List<Book> lstBook;
    public List<Book> getLstBook() {
        return lstBook;
    }
    public void setLstBook(List<Book> lstBook) {
        this.lstBook = lstBook;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "lstBook=" + lstBook +
                '}';
    }
}
