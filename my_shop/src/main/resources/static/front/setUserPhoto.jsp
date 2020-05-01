<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的头像</title>
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
		<div id="login">
			<h1>我的头像</h1>
			<form action="../UserServlet?action=userPhotomodify" method="post" enctype="multipart/form-data" onsubmit="return checkSubmit()">
				<input type="hidden" name="" value=""/>
				<table>
					<tr>
						<td align="right" style="width:80px;">我的头像：</td>
						<td style="width:270px;"><input type="file" name="photo" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="设置为我的头像" class="button"/></td>
						<td><span></span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>