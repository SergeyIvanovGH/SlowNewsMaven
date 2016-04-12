package ua.com.univerpulse.model.weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Weather {
    private String timezone;
    private double latitude;
    private double longitude;
    private long time;
    private String summary;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private double pressure;

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double preassure) {
        this.pressure = preassure * 1.01325;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = Math.floor(((temperature - 32.0)*5.0)/9.0 + 0.5);
    }

    public long getTime() {
        return this.time;
    }

    public String getTimeByFormat() {
        DateFormat formatter = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        return formatter.format(new Date(this.time));
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed * 1.60934;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weather in ");
        sb.append(timezone).append(": at ");
        sb.append(getTimeByFormat()).append(", ");
        sb.append(summary).append(", ");
        sb.append(temperature).append(" &#8451;");  // Symbol DEGREE CELSIUS in HTML
        return sb.toString();
    }
}
