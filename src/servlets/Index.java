package servlets;

import infrastructure.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static servlets.Routes.*;

@WebServlet(INDEX)
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("authenticated") != null &&
                (Boolean) session.getAttribute("authenticated")) {
            resp.sendRedirect(req.getContextPath() + ARTICLES);
        } else {
            getServletContext().getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (InMemoryUserRepository.getInstance().findByLoginPassword(login, password).isPresent()) {
            req.getSession().setAttribute("authenticated", true);
            resp.sendRedirect(req.getContextPath() + ARTICLES);
        }
    }
}
