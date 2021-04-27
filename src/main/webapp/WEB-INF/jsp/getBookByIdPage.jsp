<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<body style="background-image: url('https://images.unsplash.com/photo-1554625170-a99bf5e957c9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80')">
<center><h1>PDP page:Product Detail Page</h1></center>
<table align="center" border="2" width="70%" cellpadding="2" style="background-image: url('https://images.unsplash.com/photo-1589447388175-ac47d31be950?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80')">
    <tr><th>bookId</th><th>bookName</th><th>bookAuthor</th><th>bookPrice</th><th>bookPublishDate</th><th>sellerName</th>><th>publication</th>></tr>
    <tr>
        <td>${bookObject.bookId}</td>
        <td>${bookObject.bookName}</td>
        <td>${bookObject.bookAuthor}</td>
        <td>${bookObject.bookPrice}</td>
        <td>${bookObject.bookPublishDate}</td>
        <td>${bookObject.sellerName}</td>
        <td>${bookObject.publication}</td>
    </tr>
</table>
<br>
<center><c:url value="/homepage" var="sam"></c:url>
    <a href="${sam}" style="color: white">Homepage</a></center>
</body>