<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13/06/2023
  Time: 8:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>${errors}</h3>
<a href="admin/user?action=create">Đăng ký</a>

<form action="login" method="post">
    <label for="user_name">Tài khoản</label>
    <input type="text" name="user_name" id="user_name">
    <label for="user_password">Mật khẩu</label>
    <input type="password" name="user_password" id="user_password">
    <button>Submit</button>
</form>

</body>
</html>
