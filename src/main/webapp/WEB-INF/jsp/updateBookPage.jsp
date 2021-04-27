<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/17/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<center><h1>Add Book to Data Base</h1></center>
<div align="center">
    <c:url value="/updateBook" var="update"></c:url>
    <f:form action="${update}" method="post" modelAttribute="bookObject1">
        <f:label path="bookId">BOOK_ID:</f:label>
        <f:input path="bookId"/><br>
        <f:label path="bookName">BOOK_NAME:</f:label>
        <f:input path="bookName"/><br>
        <f:label path="bookAuthor">BOOK_AUTHOR:</f:label>
        <f:input path="bookAuthor"/><br>
        <f:label path="bookPrice">BOOK_PRICE:</f:label>
        <f:input path="bookPrice"/><br>
        <f:label path="bookPublishDate">BOOK_PUBLISH_DATE:</f:label>
        <f:input path="bookPublishDate"/><br>
        <f:label path="sellerName">SELLER_NAME:</f:label>
        <f:input path="sellerName"/><br>
        <f:label path="publication">PUBLICATION:</f:label>
        <f:input path="publication"/><br>
        <f:button value="submit">Submit</f:button>
    </f:form>
</div>
</body>
</html>
