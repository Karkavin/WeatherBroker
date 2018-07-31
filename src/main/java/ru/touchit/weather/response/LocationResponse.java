package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse implements Serializable {
    /** Поле: город */
    private String city;

    /** Поле: регион */
    private String region;

    /** Поле: страна */
    private String country;

    /**
     * Конструктор
     */
    public LocationResponse() {

    }

    /**
     * Конструктор
     * @param city город
     * @param country страна
     * @param region регион
     */
    public LocationResponse(String city, String country, String region) {
        this.city = city;
        this.country = country;
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}