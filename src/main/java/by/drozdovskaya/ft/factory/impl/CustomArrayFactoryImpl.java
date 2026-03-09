package by.drozdovskaya.ft.factory.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import by.drozdovskaya.ft.factory.CustomArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private static final Logger logger = LogManager.getLogger(CustomArrayFactoryImpl.class);

    @Override
    public CustomArray createArray(int[] elements) {
        return new CustomArray(elements);
    }

    @Override
    public CustomArray createArrayFromLine(String line) throws ArrayException {
        try {
            String[] parts = line.trim().split("[\\s;,-]+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
            return new CustomArray(numbers);
        } catch (Exception e) {
            logger.error("Parse error in line: {}", line);
            throw new ArrayException("Factory error", e);
        }
    }
}