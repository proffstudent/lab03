<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
  <form method="post" action="/login" class="login">
    <p>
      <label for="login">Логин:</label>
      <input type="text" name="login" id="login" value="test">
    </p>
    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="password" id="password" value="" placeholder="пароль">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Войти</button>
    </p>

    <p class="forgot-password"><a href="/registration">Регистрация</a></p>
  </form>
</body>
</html>
