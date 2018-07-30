package ru.touchit.weather.jms;

import ru.touchit.weather.response.WeatherResponse;

public interface JmsSender {
    void send(WeatherResponse weatherResponse);
}