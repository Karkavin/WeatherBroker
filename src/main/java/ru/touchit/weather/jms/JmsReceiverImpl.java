package ru.touchit.weather.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.touchit.api.service.WeatherService;
import ru.touchit.weather.response.WeatherResponse;

/**
 * {@inheritDoc}
 * @author Artyom Karkavin
 */
@Component
public class JmsReceiverImpl implements JmsReceiver {
    private final WeatherService weatherService;

    /**
     * Конструктор
     * @param weatherService сервис для работы с погодой
     */
    @Autowired
    public JmsReceiverImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @JmsListener(destination = JmsSenderImpl.WEATHER_TOPIC)
    public void onReceive(WeatherResponse weatherResponse) {
        weatherService.add(weatherResponse);
    }
}