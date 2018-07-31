package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse implements Serializable {
    /** Поле: информация о погоде */
    private ItemResponse item;

    /** Поле: информация о населённом пункте */
    private LocationResponse location;

    /**
     * Конструктор
     */
    public ChannelResponse() {

    }

    /**
     * Конструктор
     * @param item информация о погоде
     * @param location информация о населённом пункте
     */
    public ChannelResponse(ItemResponse item, LocationResponse location) {
        this.item = item;
        this.location = location;
    }

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }
}