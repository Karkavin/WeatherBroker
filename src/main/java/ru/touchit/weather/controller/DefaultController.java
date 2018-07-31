package ru.touchit.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер по умолчанию {@link DefaultController}
 * @author Artyom Karkavin
 */
@RestController
public class DefaultController {

    /**
     * Отображение главной страницы
     * @param modelAndView holder для model и view
     * @return index: имя view
     * @see ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        return modelAndView;
    }
}