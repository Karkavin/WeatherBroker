package ru.touchit.weather.exception;

public class NoSuchCityException extends Exception{
    public NoSuchCityException(String message) {
        super(message);
    }

    public NoSuchCityException(String message, Throwable cause) {
        super(message, cause);
    }
}