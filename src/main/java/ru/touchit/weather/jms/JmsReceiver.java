package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

public interface JmsReceiver {
    void onReceive(WeatherResponse weatherResponse);
}