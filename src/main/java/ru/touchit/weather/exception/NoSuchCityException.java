package ru.touchit.weather.exception;

/**
 * Exception для обработки ситуации отсутствия города у стороннего сервиса
 * @author Artyom Karkavin
 */
public class NoSuchCityException extends Exception{
    /**
     * {@inheritDoc}
     */
    public NoSuchCityException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public NoSuchCityException(String message, Throwable cause) {
        super(message, cause);
    }
}