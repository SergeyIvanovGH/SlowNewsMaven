package ua.com.univerpulse.model.weather;

<<<<<<< HEAD
=======
/**
 * Created by svivanov on 05.04.16.
 */
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
public enum WeatherIdentifier {
    LATITUDE("latitude"),
    LONGITUDE("longitude"),
    TIMEZONE("timezone"),
    TIME("time"),
    SUMMARY("summary"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity"),
    WIND_SPEED("windSpeed"),
    PREASSURE("pressure"),
    ZERO("undefined");

    private String nameIdentifier;

    WeatherIdentifier(String name) {
        this.nameIdentifier = name;
    }

    public String getNameIdentifier() {
        return nameIdentifier;
    }
}
