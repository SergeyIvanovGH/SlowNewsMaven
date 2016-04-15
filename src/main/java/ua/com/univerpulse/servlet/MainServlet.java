package ua.com.univerpulse.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"/news", "/archivenews", "/login", "/registration"})
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log("MainServlet.doGet() " + request.getRequestURI());

        String pageTitle = "News feed";
        switch (request.getServletPath()) {
            case "/archivenews": {
                pageTitle = "Archive news feed";
                break;
            }
            case "/login": {
                pageTitle = "Login";
                break;
            }
            case "/registration": {
                pageTitle = "Registration user";
                break;
            }
            case "/listuser": {
                pageTitle = "List of registered users";
                break;
            }
        }

        request.setAttribute("pagetitle", pageTitle);

//        if (request.getServletPath().isEmpty()) {
            // Make page with template
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/main.jsp");
            dispatcher.forward(request,response);

//            response.sendRedirect("/news");
//        }
    }
}
