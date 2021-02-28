<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>设置页面</title>
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
		<div class="prompt">欢迎来到设置界面</div>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>