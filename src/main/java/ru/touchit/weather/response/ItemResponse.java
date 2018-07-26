package ru.touchit.weather.response;

public class ItemResponse {
    private ConditionResponse condition;

    public ItemResponse() {

    }

    public ItemResponse(ConditionResponse condition) {
        this.condition = condition;
    }

    public ConditionResponse getCondition() {
        return condition;
    }

    public void setCondition(ConditionResponse condition) {
        this.condition = condition;
    }
}