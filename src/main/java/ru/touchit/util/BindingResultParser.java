package ru.touchit.util;

import org.springframework.validation.BindingResult;

public interface BindingResultParser {
    String parseBindingResultError(BindingResult bindingResult);
}