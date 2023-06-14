<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Service Manager</h1>
<form action="service_manager" method="get">
    <input type="search" name="search" id="search" value="${pageable.search}" onsearch="onClearSearch()">
    <label>
        <button id="searchButton" type="submit">Search</button>
    </label>
</form>

<c:if test="${requestScope['services'].size() != 0}">
    <table border="1px">
        <thead>
        <tr>
            <th>
                <c:if test="${pageable.sortBy == 'desc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=asc&nameField=service.service_id">
                        ID
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy == 'asc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=desc&nameField=service.service_id">
                        ID
                    </a>
                </c:if>
            </th>
            <th>
                <c:if test="${pageable.sortBy == 'desc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=asc&nameField=hotel_name">
                        Hotel
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy == 'asc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=desc&nameField=hotel_name">
                        Hotel
                    </a>
                </c:if>
            </th>
            <th>
                <c:if test="${pageable.sortBy == 'desc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=asc&nameField=transport_name">
                        Transport
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy == 'asc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=desc&nameField=transport_name">
                        Transport
                    </a>
                </c:if>
            </th>
            <th>
                <c:if test="${pageable.sortBy == 'desc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=asc&nameField=total_price">
                        Total Price
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy == 'asc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=desc&nameField=total_price">
                        Total Price
                    </a>
                </c:if>
            </th>
            <th>
                <c:if test="${pageable.sortBy == 'desc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=asc&nameField=description">
                        Description
                    </a>
                </c:if>
                <c:if test="${pageable.sortBy == 'asc'}">
                    <a href="service_manager?page=${pageable.page}&search=${pageable.search}&sortBy=desc&nameField=description">
                        Description
                    </a>
                </c:if>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service">
            <tr>
                <td>${service.getId()}</td>
                <td>${service.getHotelName().getName()}</td>
                <td>${service.getTransportName().getName()}</td>
                <td>${service.getTotalPrice()}</td>
                <td>${service.getDescription()}</td>
                <td><a onclick="return confirm('Are you sure with this choice?')" href="service_manager?action=add&id=${service.getId()}">
                    <button>Add</button>
                </a></td>
                <td><a href="service_manager?action=edit&id=${service.getId()}">
                    <button>Edit</button>
                </a></td>
                <td><a onclick="return confirm('Do you want to delete this Service?')"
                       href="service_manager?action=delete&id=${service.getId()}">
                    <button>Delete</button>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:forEach begin="1" end="${pageable.totalPage}" var="page">
        <a href="service_manager?page=${page}&search=${pageable.search}&sortBy=${pageable.sortBy}&nameField=${pageable.nameField}"><button>${page}</button></a>
    </c:forEach>
</c:if>


<h3><a href="service_manager?action=create">
    <button>Add Service</button>
</a></h3>
<script>
    function onClearSearch() {
        searchButton.click();
    }
</script>
</body>
</html>
