<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Receipts List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<style>
    .list-page {
        margin: 10px 70px 150px 150px;
    }

</style>

<p class="h1">Receipts List size: ${receipts.size()}</p>
<c:url value="/add" var="add"/>
<c:url value="/" var="home"/>
<a href="${add}">Add new Receipt</a> <a href="${home}?show=debtors">debtors only</a>
<hr>
<div class="list-page">
    <div class="card-columns">
        <c:forEach items="${receipts}" var="receipt">
            <jsp:useBean id="receipt" class="app.model.Receipt" type="app.model.Receipt"/>
            <c:choose>
                <c:when test="${receipt.paid}">
                    <div class="card border-primary mb-3" style="max-width: 18rem;">
                        <div class="card-header">Bill #${receipt.id}</div>
                        <div class="card-body text-secondary">
                            <h5 class="card-title">${receipt.companyName}</h5>
                            <c:set var="pay" value="${receipt.payment}"/>
                            <p class="card-text"><fmt:formatNumber value="${pay}" type="currency"/></p>
                            <p class="card-text">paid: ${receipt.paid}</p>
                            <p class="card-text">${receipt.date} | ${receipt.time}</p>
                            <p class="card-text">${receipt.comment}</p>
                            <a href="/edit/${receipt.id}" style="margin-right: 175px">edit</a>
                            <a href="/delete/${receipt.id}">close</a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${!receipt.paid}">
                    <div class="card border-danger mb-3" style="max-width: 18rem;">
                        <div class="card-header">Bill #${receipt.id} </div>
                        <div class="card-body text-secondary">
                            <h5 class="card-title">${receipt.companyName}</h5>
                            <c:set var="pay" value="${receipt.payment}"/>
                            <p class="card-text"><fmt:formatNumber value="${pay}" type="currency"/></p>
                            <p class="card-text">paid: ${receipt.paid}</p>
                            <p class="card-text">${receipt.date} | ${receipt.time}</p>
                            <p class="card-text">${receipt.comment}</p>
                            <a href="/edit/${receipt.id}" style="margin-right: 175px">edit</a>
                            <a href="/delete/${receipt.id}">close</a>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </c:forEach>
    </div>
</div>


<hr>

</body>
</html>
