<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Receipts List</title>
</head>
<body>


<h1>Receipts List size: ${receipts.size()}</h1>
<hr>
<c:url value="/add" var="add"/>
<a href="${add}">Add new Receipt</a>
<hr>
<c:forEach items="${receipts}" var="receipt">
    <jsp:useBean id="receipt" class="app.model.Receipt" type="app.model.Receipt"/>
    <h4>Bill #${receipt.id}</h4>
    <p>${receipt.companyName}</p>
    <c:set var="pay" value="${receipt.payment}"/>
    <p><fmt:formatNumber value="${pay}" type="currency"/></p>
    <p>paid: ${receipt.paid}</p>
    <p>${receipt.date} | ${receipt.time}</p>
    <p>${receipt.comment}</p>
    <a href="/edit/${receipt.id}">edit</a>
    <a href="/delete/${receipt.id}">delete</a>
    <hr>
</c:forEach>
<label>${receipt}</label>
</body>
</html>
