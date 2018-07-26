package ru.touchit.weather.response;

public class WeatherResponse {
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