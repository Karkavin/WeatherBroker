package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

/**
 * Отправитель сообщений в очередь
 * @author Artyom Karkavin
 */
public interface JmsSender {
    /**
     * Отправка сообщения в очередь
     * @see WeatherResponse
     */
    void send(WeatherResponse weatherResponse);
}