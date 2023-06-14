<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/06/2023
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>INFORMATION</title>
</head>
<body>
<form action="admin/user" method="get">
    <label for="search">Tìm Kiếm</label>
    <input type="search" name="search" id="search" value="${pageable.search}" onsearch="onClearSearch()">
    <button id="searchBtn">Search</button>
</form>

<c:if test="${requestScope['users'].size() != 0}">
<%--    <button>--%>
<%--        <a href="user?action=create">Đăng ký</a>--%>
<%--    </button>--%>
    <form action="user" method="post">
        <table border="1">
            <tr align="center">
                <td>ID</td>
                <td>Tài Khoản</td>
                <td>Mật Khẩu</td>
                <td>Tên</td>
                <td>Ngày sinh</td>
                <td>Giới tính</td>
                <td>Số điện thoại</td>
                <td>Email</td>
                <td>Địa chỉ</td>
                <td>Căn cước công dân</td>
                <td>Vai trò</td>
                <td colspan="2">Action</td>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.dob}</td>
                    <td>${user.gender}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>${user.cccd}</td>
                    <td>${user.role}</td>
                    <td>
                        <button>
                            <a href="/admin/user?action=update&id=${user.id}"
                               onclick="return confirm('Do you want to edit ${user.name}?')">Edit</a>
                        </button>
                    </td>
                    <td>
                        <button>
                            <a href="/admin/user?action=delete&id=${user.id}"
                               onclick="return confirm('Do you want to remove ${user.name}?')">Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <ul>
        <c:forEach begin="1" end="${pageable.totalPages}" var="page">
            <li><a href="/admin/user?page=${page}&search=${pageable.search}">${page}</a></li>
        </c:forEach>

    </ul>
</c:if>
<script>
    function onClearSearch() {
        searchBtn.click();
    }
</script>
</body>
</html>
