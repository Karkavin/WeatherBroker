package ru.touchit.weather.service;

import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.exception.WrongWeatherModelException;
import ru.touchit.weather.response.WeatherResponse;

public interface WeatherApiService {
    WeatherResponse getWeatherByCity(String city) throws WrongWeatherModelException, NoSuchCityException;
    String getWeatherProviderName();
}