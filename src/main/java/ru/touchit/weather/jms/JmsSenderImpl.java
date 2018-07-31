package ru.touchit.weather.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.touchit.weather.response.WeatherResponse;

/**
 * {@inheritDoc}
 * @author Artyom Karkavin
 */
@Component
public class JmsSenderImpl implements JmsSender {
    /** Поле: jndi имя очереди */
    public static final String WEATHER_QUEUE = "java:jboss/weather";

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(WeatherResponse weatherResponse) {
        jmsTemplate.convertAndSend(WEATHER_QUEUE, weatherResponse);
    }
}