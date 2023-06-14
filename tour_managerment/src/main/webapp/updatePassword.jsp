<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/06/2023
  Time: 3:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đổi mật khẩu</title>
</head>
<body>
<h1>${message}</h1>
<form action="/admin/user?action=updatePassword" method="post">
    <input type="hidden" name="user_id" value="${user.id}">

    <label for="user_password1">Mật khẩu cũ</label>
    <input type="password" name="old_user_password" id="user_password1">
    <br>
    <label for="user_password">Mật khẩu mới</label>
    <input type="password" name="new_user_password" id="user_password">
    <br>
<%--    <label for="updatePassword2">Nhập lại mật khẩu mới</label>--%>
<%--    <input type="password" name="user_password" id="updatePassword2">--%>
<%--    <br>--%>
    <button>Xác nhận</button>
    <button>
        <a href="login.jsp">Back</a>
    </button>
</form>
</body>
</html>
