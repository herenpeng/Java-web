<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人资料修改</title>
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
			<h1>个人资料修改</h1>
			<form action="../UserServlet" method="post" onsubmit="return checkSubmit()">
				<input type="hidden" name="action" value="usermodify"/>
				<table>
					<tr>
						<td align="right" style="width:80px;">用户名：</td>
						<td style="width:270px;"><input type="text" size="30" placeholder="请输入您的用户名" value="${user.username}" name="username" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td align="right">密码：</td>
						<td><input type="text" size="30" placeholder="请输入您的密码" value="${user.password}" name="password" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td align="right">姓名：</td>
						<td><input type="text" size="30" value="${user.name}" placeholder="请输入您的真实姓名" name="name" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td align="right">性别：</td>
						<td>
						<c:if test="${user.sex.equals('男') }">
							<input type="radio" name="sex" value="男" checked="checked" onblur="checkItem(this)"/>男
							<input type="radio" name="sex" value="女" onblur="checkItem(this)"/>女
						</c:if>
						<c:if test="${user.sex.equals('女') }">
							<input type="radio" name="sex" value="男" onblur="checkItem(this)"/>男
							<input type="radio" name="sex" value="女" checked="checked" onblur="checkItem(this)"/>女
						</c:if>
						</td>
						<td><span></span></td>
					</tr>
					<tr>
						<td align="right">出生日期：</td>
						<td><input type="date" name="birthdate" value="${user.birthdate}" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td align="right">电话号码：</td>
						<td><input type="tel" size="30" value="${user.phone}" placeholder="请输入您的手机号码" name="phone" onblur="checkItem(this)"/></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="提交修改" class="button"/></td>
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