package ru.touchit.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DefaultController {

    @RequestMapping(value="/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        return modelAndView;
    }
}