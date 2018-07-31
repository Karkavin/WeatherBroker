package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse implements Serializable{
    /** Поле: результат запроса данных из БД стороннего сервиса */
    private QueryResponse query;

    /**
     * Конструктор
     */
    public WeatherResponse() {

    }

    /**
     * Конструктор
     * @param query результат запроса данных из БД стороннего сервиса
     */
    public WeatherResponse(QueryResponse query) {
        this.query = query;
    }

    public QueryResponse getQuery() {
        return query;
    }

    public void setQuery(QueryResponse query) {
        this.query = query;
    }
}