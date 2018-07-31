package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse implements Serializable {
    /** Поле: текущая погода */
    private ConditionResponse condition;

    /** Поле: широта */
    private String lat;

    /** Поле: долгота */
    @JsonProperty(value = "long")
    private String lon;

    /**
     * Конструктор
     */
    public ItemResponse() {

    }

    /**
     * Конструктор
     * @param condition текущая погода
     * @param lat широта
     * @param lon долгота
     */
    public ItemResponse(ConditionResponse condition, String lat, String lon) {
        this.condition = condition;
        this.lat = lat;
        this.lon = lon;
    }

    public ConditionResponse getCondition() {
        return condition;
    }

    public void setCondition(ConditionResponse condition) {
        this.condition = condition;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}