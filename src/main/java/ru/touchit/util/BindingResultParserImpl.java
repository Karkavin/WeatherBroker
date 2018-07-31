package ru.touchit.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * {@inheritDoc}
 * @author Artyom Karkavin
 */
@Component
public class BindingResultParserImpl implements BindingResultParser {

    /**
     * {@inheritDoc}
     */
    @Override
    public String parseBindingResultError(BindingResult bindingResult) {
        String errorMessage = "";

        for (int i = 0; i < bindingResult.getErrorCount(); i++) {
            errorMessage += bindingResult.getAllErrors().get(i).getDefaultMessage() + ".";
            if (i != bindingResult.getErrorCount()-1) {
                errorMessage += " ";
            }
        }

        return errorMessage;
    }
}