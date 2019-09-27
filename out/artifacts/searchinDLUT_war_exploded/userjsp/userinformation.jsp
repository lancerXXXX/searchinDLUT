<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/24
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<div class ="container" role="main">
<c:set var="informationtable" value="${requestScope.informationtable}"/>
<table border="1">
    <thead>
    <tr>
        <td>电话</td>
        <td>学生id</td>
        <td>教师id</td>
        <td>qq</td>
        <td>姓名</td>
        <td>email</td>
    </tr>
        <tr>
            <td>${informationtable.getTelephone()}</td>
            <td>${informationtable.getStudentId()}</td>
            <td>${informationtable.getTeacherId()}</td>
            <td>${informationtable.getQq()}</td>
            <td>${informationtable.getName()}</td>
            <td>${informationtable.getEmail()}</td>
        </tr>
</table>
</div>
<br>
<h1>上传图片</h1>
<form action="${pageContext.request.contextPath}/user/file_upload_servlet?fileName=${informationtable.getStudentId()}${informationtable.getTeacherId()}" method="post" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" accept=".jpg"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
