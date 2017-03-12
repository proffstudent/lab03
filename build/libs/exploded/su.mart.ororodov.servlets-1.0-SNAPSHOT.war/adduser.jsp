<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>добавляем пользователей</title>
</head>
<body>
<form action="/reviews/adduser" method="post">
    <input type="hidden" name="id" id="id" value="${user.id}">
<table border="1" width="100%" cellpadding="5">
        <tr>
            <th>NAME</th>
            <th>LASTNAME</th>
            <th>EMAIL</th>
            <th>WORKPLACE</th>
            <th>ACCESSLEVEL</th>
        </tr>
        <tr>
            <td><input type="text" name="name" id="name" value="${user.name}" placeholder="name"></td>
            <td><input type="text" name="lastName" id="lastName" value="${user.lastName}" placeholder="lastName"></td>
            <td><input type="text" name="email" id="email" value="${user.email}" placeholder="email"></td>
            <td><input type="text" name="workplace" id="workplace" value="${user.workplace}" placeholder="workplace"></td>
            <td><input type="text" name="accessLevel" id="accessLevel" value="${user.accessLevel}"
                       placeholder="accessLevel"></td>
        </tr>
    </table>

    <input type="submit" value="ok" formmethod="post">
</form>
</body>
</html>
