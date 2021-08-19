package web.servlet;

import model.Message;
import model.User;
import view.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyMessage", urlPatterns = "/messenger/chats")
public class Chats extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Storage storage = Storage.getInstance();
        User currentUser = (User) req.getSession().getAttribute("user");
        List<Message> listMessage = storage.getMessageList(currentUser.getLogin());
        req.setAttribute("listMessage", listMessage);
        req.getRequestDispatcher("/views/messenger/chats.jsp").forward(req, resp);
    }
}
