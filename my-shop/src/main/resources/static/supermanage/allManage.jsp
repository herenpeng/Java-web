<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>所有管理员</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
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
	<div id="main">
		<table>
			<tr class="firstLine">
				<td style="width:50px;">管理员ID</td>
				<td style="width:150px;">用户名</td>
				<td style="width:150px;">密码</td>
				<td style="width:100px;">姓名</td>
				<td style="width:50px;">性别</td>
				<td style="width:120px;">出生日期</td>
				<td style="width:120px;">手机号码</td>
				<td>操作</td>
			</tr>
			<c:if test="${remainRow!=10}">
			<c:forEach var="manage" items="${manageList}">
				<tr>
					<td>${manage.id}</td>
					<td>${manage.username}</td>
					<td>${manage.password}</td>
					<td>${manage.name}</td>
					<td>${manage.sex}</td>
					<td>${manage.birthdate}</td>
					<td>${manage.phone}</td>
					<td><a href="../UserServlet?action=delmanage&id=${manage.id}">删除</a></td>
				</tr>
			</c:forEach>
			<c:forEach begin="1" end="${remainRow}" step="1">
				<tr class="lastLine">
					<td colspan="8"></td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${remainRow==10}">
				<tr class="lastLine">
					<td colspan="8" style="height:437px;">对不起！该页没有管理员信息</td>
				</tr>
			</c:if>
			<tr class="lastLine">
				<td colspan="6"></td>
				<td colspan="2" align="right">
				<form action="../UserServlet" method="post" onsubmit="return checkPageNumStatus()">
					<input type="hidden" name="action" value="allmanage"/>
					<input type="submit" value="-" class="modifyButton" name="jumpminus"/>
					<input type="text" size="4" value="${pageNum}" name="pageNum"/>
					<input type="submit" value="+" class="modifyButton" name="jumpplus"/>
					<input type="submit" value="跳转" name="jump" class="button"/>
				</form>
				</td>
			</tr>
		</table>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>