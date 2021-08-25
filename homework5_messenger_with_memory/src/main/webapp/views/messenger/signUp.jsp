<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;">${requestScope.msg}</p>
    </c:when>
</c:choose>
</p>
<form action="signUp" method="post">
    <p><b>Заполните данные для регистрации</b></p>
    <p>
        <label for="login">login: </label>
        <input id="login" type="text" name="login">
    </p>
    <p>
        <label for="password">password: </label>
        <input id="password" type="password" name="password">
    </p>
    <p>
        <label for="name">name: </label>
        <input id="name" type="text" name="name">
    </p>
    <p>
        <label for="birth">birth: </label>
        <input id="birth" type="date" name="birth">
    </p>
    <p><input type="reset" value="Очистить"></p>
    <p><input type="submit" value="Зарегистрироваться"></p>
</form>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
</body>
</html>
