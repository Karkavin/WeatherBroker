package ru.touchit.weather.response;

public class ResultsResponse {
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