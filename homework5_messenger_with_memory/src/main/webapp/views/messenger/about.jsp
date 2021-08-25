<%--
  Created by IntelliJ IDEA.
  User: uladz
  Date: 24.08.2021
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About app</title>
</head>
<body>
<h2>О приложении</h2>
<h4>Это приложение запущено ${timeStartUp} </h4>
<h4> Способ хранения данных: ${storageType} </h4>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
</body>
</html>
