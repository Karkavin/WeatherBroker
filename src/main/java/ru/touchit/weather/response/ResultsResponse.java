package ru.touchit.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsResponse implements Serializable {
    private ChannelResponse channel;

    public ResultsResponse() {

    }

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