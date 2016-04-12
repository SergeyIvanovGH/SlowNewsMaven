package ua.com.univerpulse.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "FilterServlet", urlPatterns = {"/*"})
public class FilterServlet implements Filter {
    private FilterConfig filterConfig;
//    private Weather weather;
//    private long timeUpdateWeather;
//    private WeatherProvider weatherProvider = WeatherProvider.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        HttpServletRequest request = (HttpServletRequest) servletRequest;


//        if ((System.currentTimeMillis() - timeUpdateWeather) > 10*60*1000) {
//            weather = weatherProvider.getWeather();
//            timeUpdateWeather = System.currentTimeMillis();
//        }
//        request.getSession().setAttribute("weather", weather);

        StringBuilder sb = new StringBuilder();
        sb.append("Request has data: ");
        sb.append(", from ip: " + servletRequest.getRemoteAddr());
        sb.append(", method: " + request.getMethod());
        sb.append(", URL: " + request.getRequestURL());
        servletContext.log(sb.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
