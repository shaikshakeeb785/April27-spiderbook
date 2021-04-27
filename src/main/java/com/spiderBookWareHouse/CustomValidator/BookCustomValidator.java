package com.spiderBookWareHouse.CustomValidator;

import com.spiderBookWareHouse.BusinessWebsiteDto.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookCustomValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return false;
    }
    @Override
    public void validate(Object o, Errors errors)
    {
        Book book1= (Book) o;

        validateBookName(book1.getBookName(),errors);
        validateBookAuthor(book1.getBookAuthor(),errors);
        validateBookPrice(book1.getBookPrice(),errors);
        validateSellerName(book1.getSellerName(),errors);
        validatebookPublishDate(book1.getBookPublishDate(),errors);
        validatebookpublication(book1.getPublication(),errors);

    }

    private void validatebookpublication(String publication, Errors errors)
        {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publication", "publication.errors", "*publication cannot be empty");

        }

    private void validatebookPublishDate(String bookPublishDate, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookPublishDate", "bookPublishDate.errors", "*bookPublishDate cannot be empty");

    }

    public void  validateBookName(String bookName,Errors errors)
    {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "bookName.errors", "*bookName cannot be empty");

    }
   public void validateBookAuthor(String bookAuthor,Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookAuthor", "bookAuthor.errors", "*bookAuthor cannot be empty");

    }
    public void validateBookPrice(Double price,Errors erros)
    {
         if(price<50||price>1000)
         {
             erros.rejectValue("bookPrice","bookPrice.errors","*bookPrice not less than 50 not greater than 1000");

         }
    }
    public void validateSellerName(String sellerName,Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellerName", "sellerName.errors", "*sellerName cannot be empty");

    }

}
