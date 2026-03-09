package by.drozdovskaya.ft.validator.impl;

import by.drozdovskaya.ft.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger(ArrayValidatorImpl.class);
    private static final String VALID_LINE_REGEX = "^[\\d\\s;,-]+$";

    @Override
    public boolean isValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            logger.warn("Line is null or empty");
            return false;
        }

        boolean isMatched = line.matches(VALID_LINE_REGEX);
        if (!isMatched) {
            logger.warn("Line does not match regex: {}", line);
        }

        return isMatched;
    }
}