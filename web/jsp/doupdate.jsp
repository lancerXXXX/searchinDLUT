<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/23
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Do Update</title>
</head>
<body>
<c:set var="information" value="${requestScope.information}"/>
<form action="${pageContext.request.contextPath}/login/do_update_servlet" method="post">
    电话:<input type="text" name="telephone" value="${information.getTelephone()}">
    <br/>
    学号： <input type="text" name="student_id" value="${information.getStudentId()}"/>
    <br/>
    教工号： <input type="text" name="teacher_id" value="${information.getTeacherId()}"/>
    <br/>
    QQ:<input type="text" name="qq" value="${information.getQq()}">
    <br/>
    姓名： <input type="text" name="name" value="${information.getName()}"/>
    <br/>
    邮件： <input type="text" name="email" value="${information.getEmail()}"/>
    <br/>
    <input type="submit" value="更改"/>
</form>
</body>
</html>
