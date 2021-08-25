package web.servlet;

import model.User;
import view.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet (name = "Users", urlPatterns = "/messenger/users")
public class Users extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        List<User> userList = userService.getAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/views/messenger/users.jsp").forward(req, resp);
    }
}
