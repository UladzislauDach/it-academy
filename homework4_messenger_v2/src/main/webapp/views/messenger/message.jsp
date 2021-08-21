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
    <c:otherwise>
        <p style="color:green;">${requestScope.msg}</p>
    </c:otherwise>
</c:choose>
</p>
<form action="message" method="post">
    <p><b>Отправим сообщение:</b></p>
    <p>
        <label for="to">Кому: </label>
        <input id="to" type="text" name="to">
    </p>
    <p>
        <label for="text">Сообщение: </label>
    </p>
    <textarea rows="3" cols="45" id="text" name="text"></textarea>
    <p><input type="submit" value="Отправить"></p>
</form>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
</body>
</html>
