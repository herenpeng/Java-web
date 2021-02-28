<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>所有用户</title>
</head>
<body>
<h1>所有用户</h1><a href="/add.jsp">新增用户</a>
<table>
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>密码</td>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><a href="/user/delete/${user.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>