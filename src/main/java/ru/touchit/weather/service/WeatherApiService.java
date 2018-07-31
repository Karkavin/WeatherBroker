package ru.touchit.weather.service;

import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.exception.WrongWeatherModelException;
import ru.touchit.weather.response.WeatherResponse;

/**
 * Сервис для получения погоды из стороннего сервиса
 * @author Artyom Karkavin
 */
public interface WeatherApiService {
    /**
     * Получение погоды из стороннего сервиса по наименованию города и добавление результата в очередь
     * @param city наименование города
     * @throws WrongWeatherModelException неверная модель погоды
     * @throws NoSuchCityException отсутствие города у стороннего сервиса
     * @return данные о погоде из стороннего сервиса
     * @see WeatherResponse
     */
    WeatherResponse getWeatherByCity(String city) throws WrongWeatherModelException, NoSuchCityException;

    /**
     * Получение наименования поставщика погоды
     * @return наименование поставщика погоды
     */
    String getWeatherProviderName();
}