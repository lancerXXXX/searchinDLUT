<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/22
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginSuccess</title>
</head>
<body>
<div style="color:burlywood">Login success</div>
<a href="${pageContext.request.contextPath}/jsp/add.jsp">增加数据</a>
<a href="${pageContext.request.contextPath}/jsp/delete.jsp">删除数据</a>
<a href="${pageContext.request.contextPath}/jsp/update.jsp">更改数据</a>
<a href="${pageContext.request.contextPath}">查找数据</a>
</body>
</html>
