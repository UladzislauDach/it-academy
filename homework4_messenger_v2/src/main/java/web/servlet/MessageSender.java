package web.servlet;

import model.User;
import view.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendMessage", urlPatterns = "/messenger/message")
public class MessageSender extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error", "");
        req.setAttribute("success", "");
        req.getRequestDispatcher("/views/messenger/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        String to = req.getParameter("to"); // кому отправляем
        String text = req.getParameter("text"); // текст сообщения
        Storage storage = Storage.getInstance();
        if (storage.addMessage(to, currentUser.getLogin(), text)) {
            req.setAttribute("success", "Успешно отправлено");
            req.setAttribute("error", "");
        } else {
            req.setAttribute("success", "");
            req.setAttribute("error", "Ошибка отправки. Такого пользователя не существует.");
        }
        req.getRequestDispatcher("/views/messenger/message.jsp").forward(req, resp);
    }
}
