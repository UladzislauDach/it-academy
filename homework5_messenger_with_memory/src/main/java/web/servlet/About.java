package web.servlet;

import storage.AppParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "About", urlPatterns = "/messenger/about")
public class About extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppParam appParam = AppParam.getInstance();
        req.setAttribute("timeStartUp", appParam.getStartTime().format(DateTimeFormatter.ofPattern("dd MM yyyy в HH:mm:ss")));
        req.setAttribute("storageType", appParam.getStorageType().getName());
        req.getRequestDispatcher("/views/messenger/about.jsp").forward(req, resp);
    }
}
