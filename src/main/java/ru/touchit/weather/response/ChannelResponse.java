package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse implements Serializable {
    private ItemResponse item;
    private LocationResponse location;

    public ChannelResponse() {

    }

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