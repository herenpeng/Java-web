<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>留言页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
<%-- 	<c:if test="${empty user.username}"> --%>
<!-- 		<script type="text/javascript"> -->
<!-- // 			alert("请先登录"); -->
<!-- // 			location.href="../front/login.jsp"; -->
<!-- 		</script> -->
<%-- 	</c:if> --%>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;商品评价留言
	</div>
	<div id="message">
		<form action="../MessageServlet" method="post">
			<input type="hidden" name="action" value="message"/>
			<table>
				<tr>
					<td><img src="../images/productImg/${messageproduct.product_imgurl}"/></td>
					<td colspan="2" rowspan="2"><textarea name="message_contents"></textarea></td>
				</tr>
				<tr>
					<td>${messageproduct.product_name}</td>
				</tr>
				<tr>
					<td colspan="2">${messageproduct.product_describe}</td>
					<td style="width:100px;text-align:right;"><input type="submit" value="留言评价" class="button"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>