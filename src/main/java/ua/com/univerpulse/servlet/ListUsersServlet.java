package ua.com.univerpulse.servlet;

import ua.com.univerpulse.dao.PersistException;
import ua.com.univerpulse.dao.PostgreDaoFactory;
import ua.com.univerpulse.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="ListUsersServlet", urlPatterns = {"/listusers"})
public class ListUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserCollection userCollection = UserCollection.getInstance();

        try {
            PostgreDaoFactory postgreDaoFactory = new PostgreDaoFactory();
            UserDao userDao = new UserDao(postgreDaoFactory.getConnection());

            req.getSession().setAttribute("listusers", userDao.getAll());

            userDao.closeConnection();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listusers.jsp");
            dispatcher.forward(req,resp);

        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
