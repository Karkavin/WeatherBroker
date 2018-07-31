package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionResponse implements Serializable {
    /** Поле: код */
    private String code;

    /** Поле: дата последнего обновления текущей погоды */
    private String date;

    /** Поле: текущая температура в единице Фаренгейт */
    private String temp;

    /** Поле: текстовое описание погоды */
    private String text;

    /**
     * Конструктор
     */
    private ConditionResponse() {

    }

    /**
     * Конструктор
     * @param code код
     * @param date дата последнего обновления текущей погоды
     * @param temp текущая температура в единице Фаренгейт
     * @param text текстовое описание погоды
     */
    public ConditionResponse(String code, String date, String temp, String text) {
        this.code = code;
        this.date = date;
        this.temp = temp;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}