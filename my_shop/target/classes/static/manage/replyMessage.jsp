<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>回复留言</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">管理后台</a>&nbsp;&gt;&nbsp;留言管理
	</div>
	<div id="message">
		<form action="../MessageServlet" method="post">
			<input type="hidden" name="action" value="reply"/>
			<table style="margin:30px auto 70px auto;">
				<tr>
					<td style="width:210px;">留言ID：${message.message_id}</td>
					<td style="width:300px;">留言用户名：${messageuser.username}</td>
					<td align="right">留言时间：${message.message_datetime}</td>
				</tr>
				<tr>
					<td colspan="3">留言内容：${message.message_contents}</td>
				</tr>
				<tr>
					<td><img src="../images/productImg/${messageproduct.product_imgurl}"/></td>
					<td colspan="2" rowspan="2"><textarea name="reply_contents">${message.reply_contents}</textarea></td>
				</tr>
				<tr>
					<td>${messageproduct.product_name}</td>
				</tr>
				<tr>
					<td colspan="2">${messageproduct.product_describe}</td>
					<td style="text-align:right;"><input type="submit" value="回复留言" class="button"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>