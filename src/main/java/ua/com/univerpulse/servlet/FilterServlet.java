package ua.com.univerpulse.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "FilterServlet", urlPatterns = {"/*"})
public class FilterServlet implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ServletContext servletContext = filterConfig.getServletContext();
//        HttpServletRequest request = (HttpServletRequest) servletRequest;

//        StringBuilder sb = new StringBuilder();
//        sb.append("Beginservlet. Request has data: ");
//        sb.append(", from ip: " + servletRequest.getRemoteAddr());
//        sb.append(", method: " + request.getMethod());
//        sb.append(", URL: " + request.getRequestURL());
//        servletContext.log(sb.toString());

        filterChain.doFilter(servletRequest, servletResponse);

//        if (request.getAttribute("news") == null) {
//            servletContext.log("No news attribute.");
//        } else {
//            servletContext.log("News attribute is true.");
//        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
