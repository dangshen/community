<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
    <h1>spring boot + spring mvc + mybatis</h1>
    <form action="user" method="post">
        用户id：<input type="text" name="user.uId">
        密  码：<input type="password" name="user.uPassword">
        <input type="submit" value="登录">
    </form>
  </body>
</html>