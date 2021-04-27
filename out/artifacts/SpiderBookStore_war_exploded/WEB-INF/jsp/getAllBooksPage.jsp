<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<body style="background-image: url('https://images.unsplash.com/photo-1554625170-a99bf5e957c9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80')">
<center><h1>Product List page: (PLP)</h1></center>
<center>
    <table border="2" width="70%" cellpadding="2"
           style="background-image: url('https://images.unsplash.com/photo-1589447388175-ac47d31be950?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80')">
        <tr>
            <th>BOOKID</th>
            <th>BOOK_NAME</th>
            <th>BOOK_AUTHOR</th>
            <th>BOOK_PRICE</th>
            <th>BOOK_PUBLISH_DATE</th>
            <th>SELLER NAME</th>
            <th>PUBLICATION</th>
            <th>DELETE</th>
            <th>UPDATE</th>
        </tr>
        <c:forEach var="object" items="${lstBookObject}">
            <tr>
                <td>
                    <%--heare i am passing bookid by using queryString and accessing in controller by using @RequestParam--%>
                    <a href="getByIdjsondata?bookId=${object.bookId}">${object.bookId}</a>
                </td>
                <td>
                    <a href="getByIdjsondata?bookId=${object.bookId}">${object.bookName}
                </td>
                <td>${object.bookAuthor}</td>
                <td>${object.bookPrice}</td>
                <td>${object.bookPublishDate}</td>
                <td>${object.sellerName}</td>
                <td>${object.publication}</td>
                    <%--heare i am passing bookid directly and accessing in controller by using @PathVareable--%>
                <c:url value="/deleteRecordById/${object.bookId}" var="delete"/>
                <td><a href="${delete}"><h3>X</h3></a></td>
                    <%--heare i am passing bookid directly and accessing in controller by using @PathVareable--%>
                <c:url value="/update/${object.bookId}" var="Edit"/>
                <td><a href="${Edit}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
<br/>
<center><c:url value="/homepage" var="homepage"/>
    <td><a href="${homepage}" style="color: white">HomePage</a></td>
</center>
</body>