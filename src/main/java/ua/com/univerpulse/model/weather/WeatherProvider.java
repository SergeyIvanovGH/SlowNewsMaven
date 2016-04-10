package ua.com.univerpulse.model.weather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class WeatherProvider {
    private static WeatherProvider ourInstance = new WeatherProvider();

    public static WeatherProvider getInstance() {
        return ourInstance;
    }

    private WeatherProvider() {
    }

    private WeatherIdentifier getIdentifierByName(String name) {
        for (WeatherIdentifier w : WeatherIdentifier.values()) {
            if (w.getNameIdentifier().equals(name)) {
                return w;
            }
        }
        return WeatherIdentifier.ZERO;
    }

    public Weather getWeather() {
        Client client = ClientBuilder.newClient();
<<<<<<< HEAD
=======
        // other site with weather forecast http://openweathermap.org/current
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
        WebTarget target = client.target("https://api.forecast.io/").path("forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");

        String stringWeatherJSON = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        String summary = stringWeatherJSON.substring(1, stringWeatherJSON.indexOf("currently")-1).replace("\"", "");
        String currently = stringWeatherJSON.substring(stringWeatherJSON.indexOf("currently")+"currently".length()+3, stringWeatherJSON.indexOf("hourly")-3).replace("\"", "");

        StringBuilder stringBuilder = new StringBuilder(summary.length()+currently.length());
        stringBuilder.append(summary);
        stringBuilder.append(currently);

        String[] tokenJSON = stringBuilder.toString().split(",");
        Weather weather = new Weather();

        for (String s : tokenJSON) {
            String[] token = s.split(":");

            switch (getIdentifierByName(token[0])) {
                case LATITUDE: {
                    weather.setLatitude(Double.parseDouble(token[1]) );
                    break;
                }
                case LONGITUDE: {
                    weather.setLongitude(Double.parseDouble(token[1]) );
                    break;
                }
                case TIMEZONE: {
                    weather.setTimezone(token[1]);
                    break;
                }
                case TIME: {
                    weather.setTime(Long.parseLong(token[1])*1000);
                    break;
                }
                case SUMMARY: {
                    weather.setSummary(token[1]);
                    break;
                }
                case TEMPERATURE: {
                    weather.setTemperature(Double.parseDouble(token[1]));
                    break;
                }
                case HUMIDITY: {
                    weather.setHumidity(Double.parseDouble(token[1]));
                    break;
                }
                case WIND_SPEED: {
                    weather.setWindSpeed(Double.parseDouble(token[1]));
                    break;
                }
                case PREASSURE: {
                    weather.setPressure(Double.parseDouble(token[1]));
                    break;
                }
            }
        }
        return weather;
    }
}
