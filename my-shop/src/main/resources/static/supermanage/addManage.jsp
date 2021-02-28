<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加管理员</title>
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
		<div id="register">
		<h1>添加管理员</h1>
		<form action="../UserServlet" method="post" onsubmit="return checkSubmit()">
			<input type="hidden" name="" value=""/>
			<input type="hidden" name="action" value="addmanage"/>
			<table>
				<tr>
					<td align="right" style="width:80px;">用户名：</td>
					<td style="width:270px;"><input type="text" size="30" placeholder="请输入您的用户名"  name="username" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" size="30" placeholder="请输入您的密码" name="password" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td><input type="password" size="30" placeholder="请确认您的密码" name="repassword" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">姓名：</td>
					<td><input type="text" size="30" placeholder="请输入您的真实姓名" name="name" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>
						<input type="radio" name="sex" value="男" onblur="checkItem(this)"/>男
						<input type="radio" name="sex" value="女" onblur="checkItem(this)"/>女
					</td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">出生日期：</td>
					<td><input type="date" name="birthdate" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td align="right">电话号码：</td>
					<td><input type="tel" size="30" placeholder="请输入您的手机号码" name="phone" onblur="checkItem(this)"/></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="添加管理员" class="button"/></td>
					<td><span></span></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>