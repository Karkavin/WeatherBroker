package ru.touchit.weather.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import ru.touchit.api.service.WeatherService;
import ru.touchit.weather.response.WeatherResponse;

@Service
public class JmsReceiverImpl implements JmsReceiver {
    private final WeatherService weatherService;

    @Autowired
    public JmsReceiverImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    @JmsListener(destination = JmsSenderImpl.WEATHER_QUEUE)
    public void onReceive(WeatherResponse weatherResponse) {
        weatherService.add(weatherResponse);
    }
}