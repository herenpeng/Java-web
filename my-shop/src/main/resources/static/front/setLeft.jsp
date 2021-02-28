<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>设置子导航栏</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div id="lefter">
	<div id="childNav">
		<h2>${user.username}</h2>
		<dl>
			<dt><a href="setUser.jsp">个人资料修改</a></dt>
			<dt><a href="setUserPhoto.jsp">我的头像</a></dt>
			<dt><a href="../AddressServlet?action=findaddress&user_id=${user.id}">我的收货地址</a></dt>
			<dt><a href="../UserServlet?action=out">退出登录</a></dt>
		</dl>
	</div>
</div>
</body>
</html>