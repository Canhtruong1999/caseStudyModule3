<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/06/2023
  Time: 2:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đăng Ký</h1>
<form action="user?action=create" method="post">
    <label for="user_name">Tài Khoản</label>
    <input type="text" name="user_name" id="user_name"><br>
    <label for="user_password">Mật Khẩu</label>
    <input type="password" name="user_password" id="user_password"><br>

    <label for="full_name">Tên</label>
    <input type="text" name="full_name" id="full_name"><br>
    <label for="dob">Ngày sinh</label>
    <input type="date" name="dob" id="dob"><br>

    <label for="gender">Giới tính</label>
    <select name="gender" id="gender">
        <option>--None--</option>
        <c:forEach items="${genders}" var="gender">
            <option value="${gender}">${gender}</option>
        </c:forEach>
    </select><br>

    <label for="phone">Số điện thoại</label>
    <input type="text" name="phone" id="phone"><br>
    <label for="email">Email</label>
    <input type="email" name="email" id="email"><br>
    <label for="address">Địa chỉ</label>
    <input type="text" name="address" id="address"><br>
    <label for="cccd">Căn cước công dân</label>
    <input type="text" name="cccd" id="cccd"><br>

    <button type="submit" onclick="alert('Thêm thành công!')">Đăng ký</button>
    <button>
        <a href="login.jsp">Back</a>
    </button>
</form>
</body>
</html>
