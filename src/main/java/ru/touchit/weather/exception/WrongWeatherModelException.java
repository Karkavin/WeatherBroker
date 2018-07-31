package ru.touchit.weather.exception;

/**
 * Exception для обработки ситуации неверной модели погоды, приходящей со стороннего сервиса
 * @author Artyom Karkavin
 */
public class WrongWeatherModelException extends Exception {
    /**
     * {@inheritDoc}
     */
    public WrongWeatherModelException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public WrongWeatherModelException(String message, Throwable cause) {
        super(message, cause);
    }
}