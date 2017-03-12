<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<h1>Users</h1>
<form action="users" method="post">
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LASTNAME</th>
        <th>EMAIL</th>
        <th>WORKPLACE</th>
        <th>ACCESSLEVEL</th>
        <th>OPERATION</th>
    </tr>
    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.lastName}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.workplace}"></c:out></td>
            <td><c:out value="${user.accessLevel}"></c:out></td>
            <td><a href="/reviews/adduser?id=${user.id}">edit</a>
                /
                <a href="/reviews/deleteuser?id=${user.id}">del</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/reviews/adduser?id=${0}">Добавить</a>
</form>
</body>
</html>
