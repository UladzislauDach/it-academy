<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="view.Storage" %>
<%@ page import="model.User" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<h4> Привет,  <%=session.getAttribute("login")%>
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
