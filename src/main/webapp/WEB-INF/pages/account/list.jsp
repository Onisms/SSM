<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2020/4/20
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎：${ sessionScope.loginAccount.name}</h1>
<h1><a href="logout">注销</a></h1>
</body>
</html>
