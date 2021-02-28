<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>提示页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;提示页面
	</div>
	<div class="prompt"><%= session.getAttribute("prompt")%></div>
	<script type="text/javascript">
		setTimeout("location.href='<%= session.getAttribute("href")%>'", 3000);
	</script>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>