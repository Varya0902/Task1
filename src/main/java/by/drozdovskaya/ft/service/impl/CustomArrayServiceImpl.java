package by.drozdovskaya.ft.service.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import by.drozdovskaya.ft.service.CustomArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayServiceImpl implements CustomArrayService {
    private static final Logger logger = LogManager.getLogger(CustomArrayServiceImpl.class);

    private void check(CustomArray array) throws ArrayException {
        if (array == null || array.getElements() == null || array.getElements().length == 0) {
            logger.error("Array is empty/null");
            throw new ArrayException("Empty array");
        }
    }

    @Override
    public int findMin(CustomArray array) throws ArrayException {
        check(array);
        int min = array.getElements()[0];
        for (int i : array.getElements()) if (i < min) min = i;
        logger.info("Min: {}", min);
        return min;
    }

    @Override
    public int findMax(CustomArray array) throws ArrayException {
        check(array);
        int max = array.getElements()[0];
        for (int i : array.getElements()) if (i > max) max = i;
        logger.info("Max: {}", max);
        return max;
    }

    @Override
    public int calculateSum(CustomArray array) throws ArrayException {
        check(array);
        int sum = 0;
        for (int i : array.getElements()) sum += i;
        logger.info("Sum: {}", sum);
        return sum;
    }

    @Override
    public void sortBubble(CustomArray array) throws ArrayException {
        check(array);
        int[] el = array.getElements();
        for (int i = 0; i < el.length - 1; i++) {
            for (int j = 0; j < el.length - i - 1; j++) {
                if (el[j] > el[j + 1]) {
                    int tmp = el[j]; el[j] = el[j + 1]; el[j + 1] = tmp;
                }
            }
        }
        logger.info("Bubble sort done");
    }

    @Override
    public void sortInsertion(CustomArray array) throws ArrayException {
        check(array);
        int[] el = array.getElements();
        for (int i = 1; i < el.length; i++) {
            int key = el[i];
            int j = i - 1;
            while (j >= 0 && el[j] > key) {
                el[j + 1] = el[j];
                j--;
            }
            el[j + 1] = key;
        }
        logger.info("Insertion sort done");
    }
}