<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/22
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login/add_servlet" method="post">
    电话号码: <input type="text" name="telephone">
    <br/>
    学号 ： <input type="text" name="student_id"/>
    <br/>
    教工号 ： <input type="text" name="teacher_id"/>
    <br/>
    QQ : <input type="text" name="qq">
    <br/>
    姓名 ： <input type="text" name="name"/>
    <br/>
    邮件 ： <input type="text" name="email"/>
    <br/>
    <input type="submit" value="增加"/>
</form>
</body>
</html>
