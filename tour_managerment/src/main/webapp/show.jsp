<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/6/2023
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="tours" method="get">
    <input type="search" name="search" id="search" value="${pageable.search}" onsearch="onClearSearch()" />
    <button id="searchButton">Search</button>
</form>
</br>
<a href="tours?action=create">Create Book</a>
<c:if test="${requestScope['tours'].size() != 0}">
    <table border="1">
        <tr>
            <td>
                <c:if test="${pageable.sortBy== 'desc'}">
                    <a href="tours?page=${pageable.page}&search=${pageable.search}&sortby=asc&fieldName=t1.tour_id">
                        Id
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy== 'asc'}">
                    <a href="tours?page=${pageable.page}&search=${pageable.search}&sortby=desc&fieldName=t1.tour_id">
                        Id
                    </a>
                </c:if>
            </td>
            <td>Name</td>
            <td>price</td>
            <td>start_time</td>
            <td>end_time</td>
            <td>img</td>
            <td>description</td>
            <td>tags</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${tours}" var="tour">
            <tr>
                <td>${tour.tour_id}</td>
                <td>${tour.name}</td>
                <td>${tour.price}</td>
                <td>${tour.start_time}</td>
                <td>${tour.end_time}</td>
                <td>${tour.img}</td>
                <td>${tour.description}</td>
                <td>${tour.tour_tag}</td>
                <td><a href="tours?action=edit&id=${tour.tour_id}">Edit</a> </td>
                <td><a href="tours?action=delete&id=${tour.tour_id}" onclick="return confirm('Do you want to remove ${book.name}?')">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
    <ul>
        <c:forEach begin="1" end="${pageable.totalPage}" var="page">
            <li><a href="tours?page=${page}&search=${pageable.search}">${page}</a> </li>
        </c:forEach>

    </ul>
</c:if>
<script>
    function onClearSearch(){
        searchButton.click();
    }
</script>
</body>
</html>
