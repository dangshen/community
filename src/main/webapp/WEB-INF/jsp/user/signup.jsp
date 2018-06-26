<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/26
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
    <form action="/user/signUp">
        <h3>注册页面</h3>
        用户id:<input type="text" name="uId">
        密  码:<input type="password" name="uPassword">
        昵  称:<input type="text" name="uName">
        <input type="submit" value="注册">
    </form>
</body>
</html>
