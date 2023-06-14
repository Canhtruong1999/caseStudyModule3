<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/06/2023
  Time: 3:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đổi thông tin</title>
</head>
<body>
<form action="/admin/user?action=updateInfo" method="post">
    <input type="hidden" name="user_id" value="${user.id}">

    <label for="full_name">Tên</label>
    <input type="text" name="full_name" id="full_name" value="${user.name}"><br>
    <label for="dob">Ngày sinh</label>
    <input type="date" name="dob" id="dob" value="${user.dob}"><br>

    <label for="gender">Giới tính</label>
    <select name="gender" id="gender" value="${user.gender}">
        <option>--None--</option>
        <c:forEach items="${genders}" var="gender">
            <option value="${gender}">${gender}</option>
        </c:forEach>
    </select><br>

    <label for="phone">Số điện thoại</label>
    <input type="text" name="phone" id="phone" value="${user.phone}"><br>
    <label for="email">Email</label>
    <input type="email" name="email" id="email" value="${user.email}"><br>
    <label for="address">Địa chỉ</label>
    <input type="text" name="address" id="address" value="${user.address}"><br>
    <label for="cccd">Căn cước công dân</label>
    <input type="text" name="cccd" id="cccd" value="${user.cccd}"><br>
    <button>Xác nhận</button>
    <button>
        <a href="login.jsp">Back</a>
    </button>
</form>
</body>
</html>
