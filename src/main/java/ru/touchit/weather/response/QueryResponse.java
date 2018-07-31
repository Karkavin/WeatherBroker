package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponse implements Serializable {
    /** Поле: количество возвращаемых записей */
    private Long count;

    /** Поле: дата формирования ответа */
    private String created;

    /** Поле: язык */
    private String lang;

    /** Поле: результаты запроса */
    private ResultsResponse results;

    /**
     * Конструктор
     */
    public QueryResponse() {

    }

    /**
     * Конструктор
     * @param count количество возвращаемых записей
     * @param created дата формирования ответа
     * @param lang язык
     * @param results результаты запроса
     */
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