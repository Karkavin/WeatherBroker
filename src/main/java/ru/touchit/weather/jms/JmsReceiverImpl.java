package ru.touchit.weather.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.touchit.weather.response.WeatherResponse;

@Component
public class JmsReceiverImpl implements JmsReceiver {

    @Override
    @JmsListener(destination = JmsSenderImpl.WEATHER_QUEUE)
    public void onReceive(WeatherResponse weatherResponse) {

    }
}