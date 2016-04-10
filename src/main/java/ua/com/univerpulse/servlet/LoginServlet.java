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


@WebServlet(name = "loginservlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  (HttpSession) request.getSession();

        UserCollection userCollection = UserCollection.getInstance();
        User user = userCollection.identifyUser(request.getParameter("login"), request.getParameter("passwd"));
        if (user == null) {
            request.setAttribute("error_message", "User not found !");
            session.setAttribute("username", "");

            doGet(request, response);
        }
        else {
            session.setAttribute("username", user.getName());
            response.sendRedirect("news");
        }
    }
}
