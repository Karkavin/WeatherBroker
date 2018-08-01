package ru.touchit.weather.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.touchit.weather.response.WeatherResponse;

/**
 * {@inheritDoc}
 * @author Artyom Karkavin
 */
@Service
public class JmsSenderImpl implements JmsSender {
    /** Поле: имя для topic */
    public static final String WEATHER_TOPIC = "java:jboss/weather";

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(WeatherResponse weatherResponse) {
        jmsTemplate.convertAndSend(WEATHER_TOPIC, weatherResponse);
    }
}