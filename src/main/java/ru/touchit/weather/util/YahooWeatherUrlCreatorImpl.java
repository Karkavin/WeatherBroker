package ru.touchit.weather.util;

import org.springframework.stereotype.Component;

@Component
public class YahooWeatherUrlCreatorImpl implements WeatherUrlCreator {

    @Override
    public String create(String city) {
        String base = "https://query.yahooapis.com/v1/public";
        String yqlPrefix = "/yql?q=";
        String yqlQuery = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + city + "\")";
        String addition = "&format=json&env=store://datatables.org/alltableswithkeys";

        return base + yqlPrefix + yqlQuery + addition;
    }
}