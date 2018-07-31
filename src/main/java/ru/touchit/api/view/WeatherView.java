package ru.touchit.api.view;

public class WeatherView {
    private String date;
    private short temp;
    private String text;
    private double lat;
    private double lon;
    private String city;
    private String region;
    private String country;

    public WeatherView() {

    }

    public WeatherView(String date, short temp, String text, double lat, double lon, String city, String region, String country) {
        this.date = date;
        this.temp = temp;
        this.text = text;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public short getTemp() {
        return temp;
    }

    public void setTemp(short temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}