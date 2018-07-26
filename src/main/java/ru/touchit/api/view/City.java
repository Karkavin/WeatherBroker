package ru.touchit.api.view;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class City {
    @NotNull(message = "Название города не должно быть null")
    @Length(min = 1, message = "Длина названия города должа содержать как минимум один символ")
    private String name;

    public City() {

    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}