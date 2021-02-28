<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的收货地址</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
	<c:if test="${empty user.username}">
		<script type="text/javascript">
			alert('请先登录');
			location.href="../front/login.jsp";
		</script>
	</c:if>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;设置
	</div>
	<%@include file="setLeft.jsp" %>
	<div id="main">
		<div id="register">
			<h1>我的收货地址</h1>
			<form action="../AddressServlet?user_id=${user.id}" method="post">
				<input type="hidden" name="action" value="updateaddress"/>
				<table>
					<tr>
						<td align="right" style="width:80px;">收货地址1</td>
						<td style="width:270px;"><textarea name="address1">${address1.user_address}</textarea></td>
						<td></td>
					</tr>
					<tr>
						<td align="right">收货地址2</td>
						<td><textarea name="address2">${address2.user_address}</textarea></td>
						<td></td>
					</tr>
					<tr>
						<td align="right">收货地址3</td>
						<td><textarea name="address3">${address3.user_address}</textarea></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="确认" class="button"/></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>