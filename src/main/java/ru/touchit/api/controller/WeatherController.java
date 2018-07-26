package ru.touchit.api.controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.touchit.api.view.City;
import ru.touchit.util.BindingResultParser;

import javax.validation.Valid;

@RestController
public class WeatherController {
    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public ModelAndView enterCity() {
        return new ModelAndView("city", "city", new City());
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ModelAndView submitCity(@Valid @ModelAttribute("city") City city, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("cause", BindingResultParser.parseBindingResultError(result));

            return new ModelAndView("errorMessage", model);
        }

        return new ModelAndView("success");
    }
}