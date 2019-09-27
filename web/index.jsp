<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/11
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Search in DLUT</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/jspnofilter/login.jsp">管理员登录</a><br>
<a href="${pageContext.request.contextPath}/jspnofilter/userlogin.jsp">用户登录</a><br>
<a href="${pageContext.request.contextPath}/jspnofilter/searchphoto.jsp">以图搜人</a>
<form action="${pageContext.request.contextPath}/search_servlet" method="GET">
    电话号码: <input type="text" name="telephone">
    <br />
    学号：    <input type="text" name="student_id" /> <input type="checkbox" name="student_check_box">
    <br />
    教工号：  <input type="text" name="teacher_id" /><input type="checkbox" name="teacher_check_box">
    <br />
    QQ:      <input type="text" name="qq">
    <br />
    姓名：   <input type="text" name="name" />
    <br />
    邮件：   <input type="text" name="email" />
    <br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>
