<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25710
  Date: 2019/9/23
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除模块查询结果</title>
</head>
<body>
<div class="container" role="main">

    <c:set var="informations" value="${requestScope.informationList}"/>
    <c:set var="pagination" value="${requestScope.pagination}"/>
    <c:set var="page" value="${requestScope.page}"/>
    <c:set var="totalPages" value="${pagination.getPageCount()}"/>
    <c:set var="pageUrl" value="${requestScope.url}"/>
    <c:set var="perPageUrl" value="${requestScope.perpageurl}"/>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <form action="<c:url value="${perPageUrl}page=1"/>" method="post">
                <p>用户总数:${pagination.getTotalCount()}，每页用户数:<input name="countPerPage" type="text" value="${pagination.getCountPerPage()}"/>(<input type="submit" value="修改"/>)，总页数:${pagination.getPageCount()}，当前页:${page}</p>
            </form>

        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-8 table-responsive">
            <table class="table table-hover table-striped table-bordered table-sm" border="1">
                <thead>
                <tr>
                    <td>电话</td>
                    <td>学生id</td>
                    <td>教师id</td>
                    <td>qq</td>
                    <td>姓名</td>
                    <td>email</td>
                    <td>删除</td>
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
                        <td><a href="${pageContext.request.contextPath}/login/delete_servlet?student_id=${user.getStudentId()}&teacher_id=${user.getTeacherId()}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <div class="row justify-content-center">
        <div>
            <nav>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="<c:url value="${pageUrl}page=1"/>">首页</a></li>
                    <li class="page-item"><a class="page-link" href="<c:url value="${pageUrl}page=${page-1>1?page-1:1}"/>">&laquo;</a>
                    </li>

                    <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                        <c:set var="active" value="${loop.index==page?'active':''}"/>
                        <li class="page-item ${active}">
                            <a class="page-link" href="<c:url value="${pageUrl}page=${loop.index}"/>">${loop.index}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="<c:url value="${pageUrl}page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="<c:url value="${pageUrl}page=${totalPages}"/>">尾页</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>

</body>

</html>
