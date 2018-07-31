package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Response с данными о погоде со стороннего сервиса
 * @author Artyom Karkavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsResponse implements Serializable {
    /** Поле: канал */
    private ChannelResponse channel;

    /**
     * Конструктор
     */
    public ResultsResponse() {

    }
    /**
     * Конструктор
     * @param channel канал
     */
    public ResultsResponse(ChannelResponse channel) {
        this.channel = channel;
    }

    public ChannelResponse getChannel() {
        return channel;
    }

    public void setChannel(ChannelResponse channel) {
        this.channel = channel;
    }
}