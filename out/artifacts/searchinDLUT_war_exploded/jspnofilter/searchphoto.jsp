<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/25
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>以脸搜脸查询界面</title>
</head>
<body>
<h1>上传图片</h1>
<form action="${pageContext.request.contextPath}/search_by_photo_servlet" method="post" enctype="multipart/form-data">
    <input type="file" name="search_by">
    <br/>
    <input type="submit" name="以此搜索">
</form>
</body>
</html>
