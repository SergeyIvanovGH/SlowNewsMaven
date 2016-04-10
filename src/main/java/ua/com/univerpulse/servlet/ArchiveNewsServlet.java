package ua.com.univerpulse.servlet;

import ua.com.univerpulse.model.NewsCollection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by svivanov on 28.03.16.
 */
@WebServlet(name = "archivenewsservlet", urlPatterns = {"/archivenews"})
public class ArchiveNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("news", NewsCollection.getInstance().getArchivewNews());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/archivenews.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsCollection.getInstance().deleteNewsFromArchive(req.getParameter("newsid"));

        resp.sendRedirect("archivenews");
    }
}
