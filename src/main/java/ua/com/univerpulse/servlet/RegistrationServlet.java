package ua.com.univerpulse.servlet;

import ua.com.univerpulse.model.User;
import ua.com.univerpulse.model.UserCollection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session =  (HttpSession) req.getSession();

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("passwd"));

        UserCollection.getInstance().addUser(user);

        session.setAttribute("username", user.getName());
//        resp.sendRedirect("/SlowNewsMaven/news");
    }

}
