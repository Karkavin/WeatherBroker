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

import javax.validation.Valid;

/**
 * Контроллер для работы со сторонним сервисом получения погоды {@link WeatherApiController}
 * @author Artyom Karkavin
 */
@RestController
public class WeatherApiController {
    private final WeatherApiService weatherApiService;
    private final BindingResultParser bindingResultParser;

    /**
     * Конструктор
     * @param weatherApiService - сервис для работы со сторонним сервисом получения погоды
     * @param bindingResultParser - парсер результата валидации приходящего JSON
     */
    @Autowired
    public WeatherApiController(WeatherApiService weatherApiService, BindingResultParser bindingResultParser) {
        this.weatherApiService = weatherApiService;
        this.bindingResultParser = bindingResultParser;
    }

    /**
     * Отображение страницы для ввода города для получения погоды
     * @return holder с именем view и пустой формой
     * @see ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public ModelAndView enterCity() {
        return new ModelAndView("city", "city", new CityRequest());
    }

    /**
     * Получение погоды из стороннего сервиса и отображение страницы с результатом
     * @param cityRequest данные с формы
     * @param result информация о результатах валидации JSON
     * @param model модель
     * @return holder с именем view и моделью
     * @see ModelAndView
     * @see CityRequest
     * @see BindingResult
     * @see ModelMap
     */
    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ModelAndView submitCity(@ModelAttribute("city") @Valid CityRequest cityRequest, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("cause", bindingResultParser.parseBindingResultError(result));

            return new ModelAndView("errorMessage", model);
        }

        try {
            weatherApiService.getWeatherByCity(cityRequest.getName());
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