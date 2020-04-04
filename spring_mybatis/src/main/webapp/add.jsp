<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form action="/user/save" method="post">
    姓名：<input type="text" name="name">
    密码：<input type="text" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
