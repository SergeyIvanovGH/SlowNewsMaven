package ua.com.univerpulse.servlet;

import ua.com.univerpulse.model.weather.Weather;
import ua.com.univerpulse.model.weather.WeatherProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by svivanov on 11.04.16.
 */
@WebServlet(name = "WeatherServlet", urlPatterns = {"/weather"})
public class WeatherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Weather weather = WeatherProvider.getInstance().getWeather();
        PrintWriter pw = response.getWriter();
        pw.print(weather);
    }
}
