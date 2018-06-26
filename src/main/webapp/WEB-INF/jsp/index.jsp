<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/26
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="/user/signOut">
        <h1>欢迎！${sessionScope.get("user").uName}</h1>
        <input type="submit" value="退出登录" >
    </form>
</body>
</html>
