<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Service</h1>

<c:if test="${requestScope['message'] != null}">
    <h1>${message}</h1>
</c:if>

<form action="service_manager?action=edit" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${service.getId()}">
        <label for="hotel">Hotel</label>
        <select name="hotel" id="hotel">
            <option>--None--</option>
            <c:forEach items="${requestScope.hotels}" var="hotel">
                <c:if test="${service.getHotelName().id != hotel.id}">
                    <option value="${hotel.id}">${hotel.name} - ${hotel.price}</option>
                </c:if>
                <c:if test="${service.getHotelName().id == hotel.id}">
                    <option selected value="${hotel.id}">${hotel.name} - ${hotel.price}</option>
                    <p>${hotel.description}</p>
                </c:if>
            </c:forEach>
        </select>

        <label for="transport">Transport</label>
        <select name="transport" id="transport">
            <option>--None--</option>
            <c:forEach items="${requestScope.transports}" var="transport">
                <c:if test="${service.getTransportName().id != transport.id}">
                    <option value="${transport.id}">${transport.name} - ${transport.price}</option>
                </c:if>
                <c:if test="${service.getTransportName().id == transport.id}">
                    <option selected value="${transport.id}">${transport.name} - ${transport.price}</option>
                </c:if>
            </c:forEach>

        </select> <br>

        <button type="submit">Edit</button>
    </fieldset>
</form>

<c:if test="${requestScope['totalPrice'] != null}">
    <h1>Total Price: ${totalPrice}</h1>
</c:if>
<a href="service_manager"><button>Back</button></a>

</body>
</html>
