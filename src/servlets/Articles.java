package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static servlets.Routes.*;

@WebServlet(ARTICLES)
public class Articles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("disconnect") != null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + INDEX);
            return;
        }
        req.getRequestDispatcher("/WEB-INF" + ARTICLES_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
