<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
      <form method="post" action="index">
          <table border="1" width="100%" cellpadding="5">
              <tr>
                  <th>ID</th>
                  <th>TITLE</th>
                  <th>SUBJECT</th>
              </tr>
              <c:forEach items="${articles}" var="article">

                  <tr>
                      <td><c:out value="${article.id}"></c:out></td>
                      <td><c:out value="${article.title}"></c:out></td>
                      <td><c:out value="${article.subject}"></c:out></td>
                  </tr>
              </c:forEach>
          </table>
      </form>

    <p class="forgot-password"><a href="/login">Login</a></p>
  </form>
</body>
</html>
