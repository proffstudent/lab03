<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <link rel="stylesheet" href="/css/style.css">
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

        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.lastName}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.workplace}"></c:out></td>
            <td><c:out value="${user.accessLevel}"></c:out></td>
            <td><a href="/adduser?id=${user.id}">edit</a>
        </tr>
</table>
</form>
</body>
</html>
