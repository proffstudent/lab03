<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/reviews/registration" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value="" placeholder="Input">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="" placeholder="Input">
        <label for="email">E-MAIL:</label>
        <input type="text" name="email" id="email" value="" placeholder="Input">
        <label for="accessLevel">Выберите уровень:</label>
        <select size="3" id="accessLevel" name="accessLevel">
            <option value="4" selected>Автор</option>
            <option value="3">Рецензент</option>
        </select></p>
        <input type="submit" value="Submit" formmethod="post">
    </form>
</body>
</html>
