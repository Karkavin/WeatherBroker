package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse implements Serializable {
    private ConditionResponse condition;
    private String lat;

    @JsonProperty(value = "long")
    private String lon;

    public ItemResponse() {

    }

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