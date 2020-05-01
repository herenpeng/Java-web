<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarker入门</title>
</head>
<body>
    <h1>${hello}</h1>
    <h1>${now?date}</h1>
    <table>
        <tr>
            <td>姓名</td>
            <td>密码</td>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </#list>
    </table>

    <#if num == 100>
        num的值是100
    <#else>
        num的值不是100
    </#if>
</body>
</html>