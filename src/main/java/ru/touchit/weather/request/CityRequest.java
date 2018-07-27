package ru.touchit.weather.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityRequest {

    @NotNull(message = "Название города не должно быть null")
    @Size(min = 1, max = 100, message = "Длина названия города должа содержать от 1 до 100 символов")
    private String name;

    public CityRequest() {

    }

    public CityRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}