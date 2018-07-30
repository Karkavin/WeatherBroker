package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse implements Serializable{
    private QueryResponse query;

    public WeatherResponse() {

    }

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