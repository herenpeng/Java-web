<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台首页</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
<%-- <c:if test="${empty user.username}"> --%>
<!-- 	<script type="text/javascript"> -->
<!--  		alert('请先登录'); -->
<!--  		location.href="../front/login.jsp"; -->
<!-- 	</script> -->
<%-- </c:if> --%>
</head>
<body>
<div id="header">
	<div id="logo">网上商城</div>
	<div id="help">
		<a href="../IndexServlet">返回前台页面</a>
		<a href="../manage/index.jsp">返回普通管理员页面</a>
	</div>
	<div id="navigator">
		<span>超级管理员${user.username}，欢迎回来！</span>
	</div>
</div>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">超级管理员</a>
	</div>
	<div id="lefter">
		<div id="childNav">
			<h2>${user.username}</h2>
			<dl>
				<dt>普通管理员账号管理</dt>
					<dd><a href="../UserServlet?action=allmanage&pageNum=1">所有管理员</a></dd>
					<dd><a href="addManage.jsp">添加管理员</a></dd>
			</dl>
		</div>
	</div>
	<div class="prompt">欢迎来到超级管理员页面</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>