package ru.touchit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.touchit.api.common.DataResponse;
import ru.touchit.api.common.ErrorResponse;
import ru.touchit.api.service.WeatherService;
import ru.touchit.api.view.WeatherView;
import ru.touchit.weather.exception.NoSuchCityException;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value="/api/weather/current/{city}", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentWeather(@PathVariable String city) {
        if (city == null || city.equals("")) {
            return ResponseEntity.unprocessableEntity().body(new ErrorResponse("Город не был введён"));
        } else {
            try {
                WeatherView weatherView = weatherService.getCurrentWeather(city);

                return ResponseEntity.ok().body(new DataResponse<>(weatherView));
            } catch (NoSuchCityException e) {
                return ResponseEntity.unprocessableEntity().body(new ErrorResponse("Погода для данного города не была найдена"));
            }
        }
    }
}