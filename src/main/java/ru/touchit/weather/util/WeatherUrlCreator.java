package ru.touchit.weather.util;

/**
 * Компоновщик url для стороннего сервиса погоды
 * @author Artyom Karkavin
 */
public interface WeatherUrlCreator {
    /**
     * Компоновщик
     * @param city наименование города
     * @return готовый для работы url
     */
    String create(String city);
}