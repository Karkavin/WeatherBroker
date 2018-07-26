package ru.touchit.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.touchit.util.BindingResultParser;
import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.exception.WrongWeatherModelException;
import ru.touchit.weather.service.WeatherApiService;
import ru.touchit.weather.request.CityRequest;
import ru.touchit.weather.response.WeatherResponse;

import javax.validation.Valid;

@RestController
public class WeatherController {
    private final WeatherApiService weatherApiService;
    private final BindingResultParser bindingResultParser;

    @Autowired
    public WeatherController(WeatherApiService weatherApiService, BindingResultParser bindingResultParser) {
        this.weatherApiService = weatherApiService;
        this.bindingResultParser = bindingResultParser;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public ModelAndView enterCity() {
        return new ModelAndView("city", "city", new CityRequest());
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ModelAndView submitCity(@ModelAttribute("city") @Valid CityRequest cityRequest, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("cause", bindingResultParser.parseBindingResultError(result));

            return new ModelAndView("errorMessage", model);
        }

        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = weatherApiService.getWeatherByCity(cityRequest.getName());
        } catch (WrongWeatherModelException e) {
            model.addAttribute("cause", "Ошибка работы с моделью погоды поставщика " + weatherApiService.getWeatherProviderName());

            return new ModelAndView("errorMessage", model);
        } catch (NoSuchCityException e) {
            model.addAttribute("cause", "Город " + cityRequest.getName() + " отсутствует в базе поставщика погоды " + weatherApiService.getWeatherProviderName());

            return new ModelAndView("errorMessage", model);
        }

        return new ModelAndView("success");
    }
}