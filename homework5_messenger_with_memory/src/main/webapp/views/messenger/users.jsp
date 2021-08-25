<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User about</title>
</head>
<body>
<h4>Все пользователи сервиса</h4>
<table border="1">
    <tr>
        <td>Логин</td>
        <td>ФИО</td>
        <td>Дата рождения</td>
        <td>Дата регистрации</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.getLogin()}</td>
            <td>${user.getName()}</td>
            <td>${user.getBirthDate()}</td>
            <td>${user.getRegistrationDateAsString()}</td>
        </tr>
    </c:forEach>
</table>
</br>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
</body>
</html>
