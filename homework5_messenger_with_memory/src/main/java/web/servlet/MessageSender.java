package web.servlet;

import model.Message;
import model.User;
import view.MessageService;
import view.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "SendMessage", urlPatterns = "/messenger/message")
public class MessageSender extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/messenger/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user"); // от кого (текущий юзер из сессии)
        String to = req.getParameter("to"); // кому отправляем
        String text = req.getParameter("text"); // текст сообщения
        UserService userService = UserService.getInstance();
        if (userService.existByLogin(to)) {
            MessageService messageService = MessageService.getInstance();
            Message message = new Message(currentUser.getLogin(), LocalDateTime.now(), text);
            messageService.add(to, message);
            req.setAttribute("msg", "Успешно отправлено");
        } else {
            req.setAttribute("error", true);
            req.setAttribute("msg", "Ошибка отправки. Такого пользователя не существует.");
        }
        req.getRequestDispatcher("/views/messenger/message.jsp").forward(req, resp);
    }
}
