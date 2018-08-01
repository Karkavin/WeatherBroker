package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

/**
 * Получатель сообщений из topic
 * @author Artyom Karkavin
 */
public interface JmsReceiver {
    /**
     * Приём сообщения из topic
     * @see WeatherResponse
     */
    void onReceive(WeatherResponse weatherResponse);
}