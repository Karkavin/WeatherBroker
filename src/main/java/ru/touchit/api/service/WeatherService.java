package ru.touchit.api.service;

import ru.touchit.api.view.WeatherView;
import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.response.WeatherResponse;

public interface WeatherService {
    void add(WeatherResponse weatherResponse);

    WeatherView getCurrentWeather(String city) throws NoSuchCityException;
}