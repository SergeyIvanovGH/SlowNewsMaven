package ua.com.univerpulse.model.weather;

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
