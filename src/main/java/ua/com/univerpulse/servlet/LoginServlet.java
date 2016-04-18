package ua.com.univerpulse.servlet;

import ua.com.univerpulse.dao.PersistException;
import ua.com.univerpulse.dao.PostgreDaoFactory;
import ua.com.univerpulse.dao.UserDao;
import ua.com.univerpulse.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "loginservlet", urlPatterns = {"/content/login"})
public class LoginServlet extends HttpServlet {
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        PostgreDaoFactory postgreDaoFactory = new PostgreDaoFactory();
        try {
            userDao = new UserDao(postgreDaoFactory.getConnection());
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  (HttpSession) request.getSession();

        User user = null;
        String login = request.getParameter("login");
        try {
            user = userDao.getByLogin(login);

            session.setAttribute("username", user.getName());
            response.getWriter().print("You are logged !");

        } catch (PersistException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().print("User not found !");
        }
    }
}
