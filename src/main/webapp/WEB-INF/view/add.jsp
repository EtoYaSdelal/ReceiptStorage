<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Receipt</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<style>
    .add-page {
        margin: 1% 35% 0 35%;
    }

    .form-text {
        color: #ea0905;
    }

</style>


<form:form class="add-page" id="newBill" action="/add" method="post" modelAttribute="receipt">
    <div class="card border-primary mb-3" style="max-width: 35rem;">
        <div class="card-header">New bill #${receipt.id}</div>
        <div class="form-group">
            <form:input type="hidden" path="id" value="${receipt.id}"/>

            <form:label for="companyName" path="companyName">Company name:</form:label>
            <form:input class="form-control" id="companyName" path="companyName"/>
            <small id="CN" class="form-text">
                <form:errors path="companyName"/>
            </small>
            <form:label for="payment" path="payment">payment:</form:label>
            <form:input class="form-control" id="payment" path="payment"/>
            <small id="pay" class="form-text">
                <form:errors path="payment"/>
            </small>
            <p></p>
            <div class="col-sm-10">
                <div class="form-check">
                    <form:radiobutton class="form-check-input" id="paid1" path="paid" value="0"/>
                    <form:label class="form-check-label" for="paid1" path="paid">unpaid</form:label>
                </div>

                <div class="form-check">
                    <form:radiobutton class="form-check-input" id="paid2" path="paid" value="1"/>
                    <form:label class="form-check-label" for="paid2" path="paid">paid</form:label>
                </div>
            </div>
            <small id="paid" class="form-text">
                <form:errors path="paid"/>
            </small>
            <form:label for="date" path="date">date:</form:label>
            <form:input class="form-control" id="date" path="date" placeholder="yyyy-MM-dd"/>
            <p></p>
            <form:label for="time" path="time">time:</form:label>
            <form:input class="form-control" id="time" path="time" placeholder="HH:mm:ss"/>
            <p></p>
            <form:label for="comment" path="comment">Comment:</form:label>
            <form:textarea class="form-control" id="comment" path="comment"></form:textarea>
            <p></p>
        </div>
    </div>
    <input type="submit" value="Add bill">
</form:form>

</body>
</html>
