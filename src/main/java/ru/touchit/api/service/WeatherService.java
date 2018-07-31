package ru.touchit.api.service;

import ru.touchit.api.view.WeatherView;
import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.response.WeatherResponse;

/**
 * Сервис для работы с погодой
 * @author Artyom Karkavin
 */
public interface WeatherService {
    /**
     * Добавление новых данных о погоде
     * @param weatherResponse информация о погоде в определённом местонахождении
     * @see WeatherResponse
     */
    void add(WeatherResponse weatherResponse);

    /**
     * Получение текущей погоды по наименованию города
     * @param city наименование города
     * @return текущая погода
     * @throws NoSuchCityException отсутствие города
     * @see WeatherView
     */
    WeatherView getCurrentWeather(String city) throws NoSuchCityException;
}