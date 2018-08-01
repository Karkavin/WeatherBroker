package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

/**
 * Отправитель сообщений в topic
 * @author Artyom Karkavin
 */
public interface JmsSender {
    /**
     * Отправка сообщения в topic
     * @see WeatherResponse
     */
    void send(WeatherResponse weatherResponse);
}