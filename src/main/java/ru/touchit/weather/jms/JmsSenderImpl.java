package ru.touchit.weather.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.touchit.weather.response.WeatherResponse;

@Component
public class JmsSenderImpl implements JmsSender {
    public static final String WEATHER_QUEUE = "java:jboss/weather";

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(WeatherResponse weatherResponse) {
        jmsTemplate.convertAndSend(WEATHER_QUEUE, weatherResponse);
    }
}