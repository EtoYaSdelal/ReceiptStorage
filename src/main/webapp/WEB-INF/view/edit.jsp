<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit page</title>
</head>
<body>
<h1>${receipt.id} | ${receipt.companyName}</h1>
<h4>Bill #${receipt.id}</h4>
<p>${receipt.companyName}</p>
<c:set var="pay" value="${receipt.payment}"/>
<p><fmt:formatNumber value="${pay}" type="currency"/></p>
<p>paid: ${receipt.paid}</p>
<p>${receipt.date} | ${receipt.time}</p>
<p>${receipt.comment}</p>
<hr>

<h3>Edit ${receipt.id}</h3>
<c:url var="var" value="/edit"/>
<form action="${var}" method="post">
    <input type="hidden" name="id" value="${receipt.id}">
    <input type="hidden" name="date" value="${receipt.date}">
    <input type="hidden" name="time" value="${receipt.time}">

    <label for="companyName">Company name:</label>
    <input id="companyName" name="companyName" value="${receipt.companyName}">
    <p></p>
    <label for="payment">payment:</label>
    <input id="payment" name="payment" value="${receipt.payment}">
    <p></p>
    <label for="paid">paid:</label>
    <input id="paid" name="paid" value="${receipt.paid}">
    <p></p>
    <label for="comment">Comment:</label>
    <textarea id="comment" name="comment">${receipt.comment}</textarea>
    <p></p>
    <input type="submit" value="Edit bill">
</form>


<hr>
<a href="${pageContext.request.contextPath}/">to list</a>
</body>
</html>
