package ru.touchit.weather.response;

public class ChannelResponse {
    private ItemResponse item;

    public ChannelResponse() {

    }

    public ChannelResponse(ItemResponse item) {
        this.item = item;
    }

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }
}