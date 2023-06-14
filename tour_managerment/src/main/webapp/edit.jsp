<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/6/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <span>${message}</span>
</c:if>
<a href="tours">Back</a>
<form action="tours?action=edit" method="post">
    <input type="hidden" name="id" value="${tour.tour_id}">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${tour.name}" /> </br>
    <label for="price">price</label>
    <input type="number" name="price" id="price" value="${tour.price}" /></br>
    <label for="start_time">start_time</label>
    <input type="date" name="start_time" id="start_time" value="${tour.start_time}" /></br>
    <label for="end_time">end_time</label>
    <input type="date" name="end_time" id="end_time" value="${tour.end_time}" /></br>
    <label for="img">img</label>
    <input type="text" name="img" id="img" value="${tour.img}" /></br>
    <label for="description">description</label>
    <input type="text" name="description" id="description" value="${tour.description}" /></br>
    <c:forEach items="${tagList}" var="tag">
        <input type='checkbox' name='myCheckbox' value='${tag.tag_id}'>
        <label>${tag.name}</label>
        <br>
    </c:forEach>


    <button type="submit">Create</button>
</form>
</body>
</html>
