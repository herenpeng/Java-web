<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>联系客服页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/javascript.js"></script>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
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
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;联系客服
	</div>
	<div id="chat">
		<div id="chatuser">
			<ul>
				<li style="background-color:#FFDDAA;">客服</li>
			</ul>
		</div>
		<div id="chathead">客服</div>
		<div id="chatcontents">
			<c:forEach var="chat" items="${chatlist}">
				<div id="chatdatetime">${chat.chat_datetime}</div>
				<c:if test="${chat.chat_userid==0}">					
					<div id="chatword" align="left"><span>${chat.chat_contents}</span></div>
				</c:if>
				<c:if test="${chat.chat_userid>0}">
					<div id="chatword" align="right"><span>${chat.chat_contents}</span></div>
				</c:if>
			</c:forEach>
		</div>
		<div id="chattext">
			<form action="../ChatServlet" method="post" >
				<input type="hidden" name="action" value="chatmanage"/>
				<textarea name="chat_contents"></textarea>
				<input type="submit" value="发送" class="button"/>
			</form>
		</div>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>