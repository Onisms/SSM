<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2020/4/14
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<h1>测试回显+修改</h1>
<form action="update" method="post">
    <%--隐藏域--%>
    <input type="hidden" name="id" value="${testBean.id}">
    用户名：<input name="name" value="${testBean.name}"><br/>
    密 码： <input name="password" value="${testBean.password}"><br/>
    <input type="submit" value="update">
</form>
</body>
</html>
