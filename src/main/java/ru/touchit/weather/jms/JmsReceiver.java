package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

/**
 * Получатель сообщений из очереди
 * @author Artyom Karkavin
 */
public interface JmsReceiver {
    /**
     * Приём сообщения из очереди
     * @see WeatherResponse
     */
    void onReceive(WeatherResponse weatherResponse);
}