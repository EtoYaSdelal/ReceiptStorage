<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Add Receipt</title>
</head>
<body>
<h3>New bill #${receipt.id}</h3>
<c:url var="var" value="/add"/>
<form action="${var}" method="post">
    <input type="hidden" name="id" value="${receipt.id}">
    <label for="companyName">Company name:</label>
    <input id="companyName" name="companyName">
    <p></p>
    <label for="payment">payment:</label>
    <input id="payment" name="payment">
    <p></p>
    <label for="paid">paid:</label>
    <input id="paid" name="paid">
    <p></p>
    <label for="date">date:</label>
    <input id="date" name="date">
    <p></p>
    <label for="time">time:</label>
    <input id="time" name="time">
    <p></p>
    <label for="comment">Comment:</label>
    <textarea id="comment" name="comment"></textarea>
    <p></p>
    <input type="submit" value="Add bill">
</form>
</body>
</html>
