<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有</title>
</head>
<body>

<a href="insertPage">跳转到添加页面</a>
<h1>所有用户集合</h1>

<c:forEach items="#{testBeanList}" var="testBean">
    ${testBean.name}------${testBean.password}
    -----<a href="delete/${testBean.id}">删除</a>
    -----<a href="queryById?id=${testBean.id}">修改</a>
    <br/>
</c:forEach>
当前是第${current}页
<c:if test="${current>1}">
    <a href="queryAllByPages?current=${current-1}">上一页</a>
</c:if>
<c:if test="${current<totalPages}">
    <a href="queryAllByPages?current=${current+1}">下一页</a>
</c:if>
共${totalPages}页
</body>
</html>
