package ru.touchit.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.exception.WrongWeatherModelException;
import ru.touchit.weather.jms.JmsSender;
import ru.touchit.weather.response.WeatherResponse;
import ru.touchit.weather.util.WeatherUrlCreator;

import java.io.IOException;

/**
 * {@inheritDoc}
 * @author Artyom Karkavin
 */
@Service("weatherApiService")
public class YahooWeatherApiServiceImpl implements WeatherApiService {
    private static final String WEATHER_PROVIDER = "Yahoo Погода";

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate;

    @Autowired
    private WeatherUrlCreator weatherUrlCreator;

    @Autowired
    JmsSender jmsSender;

    /**
     * Конструктор
     * @param restTemplateBuilder builder для построения rest клиента
     */
    public YahooWeatherApiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeatherResponse getWeatherByCity(String city) throws WrongWeatherModelException, NoSuchCityException {
        String weather = restTemplate.getForObject(weatherUrlCreator.create(city), String.class);

        WeatherResponse weatherResponse;
        try {
            weatherResponse = objectMapper.readValue(weather, WeatherResponse.class);
        } catch (IOException e) {
            throw new WrongWeatherModelException("Error with parse model of weather provider " + WEATHER_PROVIDER);
        }

        if (weatherResponse.getQuery().getResults() == null) {
            throw new NoSuchCityException("There is no such city " + city + " in database of weather provider " + WEATHER_PROVIDER);
        }

        jmsSender.send(weatherResponse);

        return weatherResponse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWeatherProviderName() {
        return WEATHER_PROVIDER;
    }
}