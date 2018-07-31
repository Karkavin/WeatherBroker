package ru.touchit.util;

import org.springframework.validation.BindingResult;

/**
 * Парсер результата валидации приходящего JSON
 * @author Artyom Karkavin
 */
public interface BindingResultParser {
    /**
     * Парсинг
     * @param bindingResult объект с информацией о валидации
     * @return сообщение пользователю с результатами
     */
    String parseBindingResultError(BindingResult bindingResult);
}