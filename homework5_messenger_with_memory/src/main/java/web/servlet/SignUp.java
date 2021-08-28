package web.servlet;

import model.User;
import view.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "Registration", urlPatterns = "/messenger/signUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info", "");
        req.getRequestDispatcher("/views/messenger/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        UserService userService = UserService.getInstance();
        User currentUser = new User(login, password, name, birth, LocalDateTime.now());
        try {
            userService.validateUserForSingUp(currentUser);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            req.setAttribute("error", true);
            req.getRequestDispatcher("/views/messenger/signUp.jsp").forward(req, resp);
            return; // очень важная строка
        }
        userService.add(currentUser);
        HttpSession session = req.getSession();
        session.setAttribute("user", currentUser);
        resp.sendRedirect("/app/messenger");
    }
}

