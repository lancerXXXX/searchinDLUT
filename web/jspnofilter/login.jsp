<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

<form action="${pageContext.request.contextPath}/login_servlet" method="post">
    账号:<input type="text" name="name"><br>
    密码:<input type="text" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
