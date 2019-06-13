<%--
  Created by IntelliJ IDEA.
  User: Fry
  Date: 6/12/2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>hello</h1>
<label>page scope: ${pageScope.size()}</label>
<p></p>
<label>${pageScope.values()}</label>
<p></p>
<h3>Attention:</h3>
<c:forEach items="${receipts}" var="receipt">
    <jsp:useBean id="receipt" class="app.model.Receipt" type="app.model.Receipt"/>
    <p>${receipt.id}</p>
    <p>${receipt.companyName}</p>
    <p>${receipt.payment}</p>
    <p>${receipt.date} | ${receipt.time}</p>
    <p>${receipt.paid}</p>
    <p>${receipt.comment}</p>
    <hr>
</c:forEach>
<label>${receipt}</label>
<p></p>
<a href="edit">to edit</a>
</body>
</html>
