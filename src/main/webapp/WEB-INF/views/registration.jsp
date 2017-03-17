<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/registration" method="post">

        <table border="1" width="100%" cellpadding="5">
            <tr>
                <th>LOGIN</th>
                <th>PASSWORD</th>
                <th>NAME</th>
                <th>LASTNAME</th>
                <th>EMAIL</th>
                <th>ACCESSLEVEL</th>
            </tr>
            <tr>
                <td><input type="text" name="login" id="login" value="" placeholder="Input"></td>
                <td><input type="password" name="password" id="password" value="" placeholder="Input"></td>
                <td><input type="text" name="name" id="name" value="${user.name}" placeholder="name"></td>
                <td><input type="text" name="lastName" id="lastName" value="${user.lastName}" placeholder="lastName"></td>
                <td><input type="text" name="email" id="email" value="${user.email}" placeholder="email"></td>
                <td>
                    <select size="3" id="accessLevel" name="accessLevel">
                        <option value="4" selected>Автор</option>
                        <option value="3">Рецензент</option>
                    </select></td>
            </tr>
        </table>
        <input type="submit" value="Submit" formmethod="post">
    </form>
</body>
</html>
