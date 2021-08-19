<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="view.Storage" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<%User currentUser = (User) session.getAttribute("user");%>
<h4> Привет,   <%=currentUser.getName()%>
</h4>
</br>
<form action="messenger/chats">
    <button>Мои сообщения</button>
</form>
</br>
<form action="messenger/message">
    <button>Отправить сообщение</button>
</form>
</br>
<form action="messenger/signOut" method="post">
    <button>Выйти из аккаунта</button>
</form>
</body>
</html>
