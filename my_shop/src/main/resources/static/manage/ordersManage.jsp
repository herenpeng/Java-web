<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单管理页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">管理后台</a>&nbsp;&gt;&nbsp;订单管理
	</div>
	<div id="lefter">
		<div id="childNav">
			<h2>${user.username}</h2>
			<dl>
				<dt>订单管理</dt>
					<dd><a href="../OrderServlet?action=allorder&pageNum=1">所有订单</a></dd>
			</dl>
		</div>
	</div>
	<div id="main">
		<div class="prompt">欢迎来到订单管理界面</div>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>