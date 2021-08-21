<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="view.UserService" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<%User currentUser = (User) session.getAttribute("user");%>


<h4> Привет,
    <c:choose>
        <с:when test="${sessionScope.user!= null}">
            ${sessionScope.user.name}
        </с:when>
        <c:otherwise>
            Гость
        </c:otherwise>
    </c:choose>
    !
</h4>
</br>

<c:choose>
    <c:when test="${sessionScope.user!=null}">

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
    </c:when>
    <c:otherwise>
        <form action="messenger/signUp">
            <button>Зарегистрироваться</button>
        </form>
        </br>
        <form action="messenger/signIn">
            <button>Войти</button>
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
