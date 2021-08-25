package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/messenger/chats", "/messenger/message","/messenger/about", "/messenger/users"})
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();

        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("user" ) != null) {
            chain.doFilter(request, response);
        } else
            res.sendRedirect(contextPath + "/messenger");
    }

    @Override
    public void destroy() {

    }
}
