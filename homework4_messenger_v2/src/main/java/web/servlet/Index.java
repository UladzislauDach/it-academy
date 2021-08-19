package web.servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainPage", urlPatterns = "/messenger")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            req.getRequestDispatcher("/views/messenger/index_un_auth.jsp").forward(req, resp);
        } else  {
            req.getRequestDispatcher("/views/messenger/index_auth.jsp").forward(req, resp);
        }
    }
}
