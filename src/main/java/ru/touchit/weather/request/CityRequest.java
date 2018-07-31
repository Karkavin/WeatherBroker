package ru.touchit.weather.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request (форма) для получения погоды по наименованию города
 * @author Artyom Karkavin
 */
public class CityRequest {
    /** Поле: наименование города */
    @NotNull(message = "Наименовение города не должно быть null")
    @Size(min = 1, max = 100, message = "Длина наименования города должа содержать от 1 до 100 символов")
    private String name;

    /**
     * Конструктор
     */
    public CityRequest() {

    }

    /**
     * Конструктор
     * @param name наименование города
     */
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