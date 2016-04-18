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
import java.io.IOException;


@WebServlet(name = "registrationservlet", urlPatterns = {"/content/registration"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session =  (HttpSession) req.getSession();

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("passwd"));

        try {
            PostgreDaoFactory postgreDaoFactory = new PostgreDaoFactory();
            UserDao userDao = new UserDao(postgreDaoFactory.getConnection());
            userDao.persist(user);
            userDao.closeConnection();
//            session.setAttribute("username", user.getName());
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

}
