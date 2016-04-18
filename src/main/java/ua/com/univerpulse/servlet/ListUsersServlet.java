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
//        UserCollection userCollection = UserCollection.getInstance();

        try {
            req.getSession().setAttribute("listusers", userDao.getAll());

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listusers.jsp");
            dispatcher.forward(req,resp);

        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
