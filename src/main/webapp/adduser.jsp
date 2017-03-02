<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>добавляем пользователей</title>
</head>
<body>
<form action="/reviews/adduser" method="post">
    <input type="hidden" name="id" id="id" value="${id}">

    <label for="name">name:</label>
    <input type="text" name="name" id="name" value="${name}" placeholder="name">

    <label for="lastname">lastname:</label>
    <input type="text" name="lastName" id="lastName" value="${lastName}" placeholder="lastName">

    <label for="email">email:</label>
    <input type="text" name="email" id="email" value="${email}" placeholder="email">

    <label for="accessLevel">accessLevel:</label>
    <input type="text" name="accessLevel" id="accessLevel" value="${accessLevel}" placeholder="accessLevel">

    <input type="submit" value="ok" formmethod="post">
</form>
</body>
</html>
