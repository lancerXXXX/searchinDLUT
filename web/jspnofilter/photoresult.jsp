<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/25
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photo Search Result</title>
</head>
<body>
<c:set var="informations" value="${requestScope.informations}"/>

<table>
    <thead>
                <tr>
                    <td>电话</td>
                    <td>学生id</td>
                    <td>教师id</td>
                    <td>qq</td>
                    <td>姓名</td>
                    <td>email</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${informations}">
                    <tr>
                        <td>${user.getTelephone()}</td>
                        <td>${user.getStudentId()}</td>
                        <td>${user.getTeacherId()}</td>
                        <td>${user.getQq()}</td>
                        <td>${user.getName()}</td>
                        <td>${user.getEmail()}</td>
                    </tr>
                </c:forEach>
                </tbody>
</table>
</body>
</html>
