<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/24
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user_login_servlet" method="post">
    学生id:<input type="text" name="student_id"><br>
    教师id:<input type="text" name="teacher_id"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
