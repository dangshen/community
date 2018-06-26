<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/25
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="/user/login" method="post">
        用户id：<input type="text" name="uId">
        密  码：<input type="password" name="uPassword">
        <input type="submit" value="登录">
    </form>
</body>
</html>
