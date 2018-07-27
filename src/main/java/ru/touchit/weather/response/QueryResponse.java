package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponse {
    private Long count;
    private String created;
    private String lang;
    private ResultsResponse results;

    public QueryResponse() {

    }

    public QueryResponse(Long count, String created, String lang, ResultsResponse results) {
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ResultsResponse getResults() {
        return results;
    }

    public void setResults(ResultsResponse results) {
        this.results = results;
    }
}