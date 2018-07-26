package ru.touchit.weather.exception;

public class WrongWeatherModelException extends Exception {
    public WrongWeatherModelException(String message) {
        super(message);
    }

    public WrongWeatherModelException(String message, Throwable cause) {
        super(message, cause);
    }
}