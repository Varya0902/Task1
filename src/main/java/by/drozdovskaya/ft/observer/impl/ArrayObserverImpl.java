package by.drozdovskaya.ft.observer.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import by.drozdovskaya.ft.observer.ArrayObserver;
import by.drozdovskaya.ft.service.CustomArrayService;
import by.drozdovskaya.ft.service.impl.CustomArrayServiceImpl;
import by.drozdovskaya.ft.warehouse.CustomArrayValues;
import by.drozdovskaya.ft.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger(ArrayObserverImpl.class);

    @Override
    public void update(CustomArray customArray) {
        CustomArrayService service = new CustomArrayServiceImpl();

        try {
            int sum = service.calculateSum(customArray);
            int max = service.findMax(customArray);
            int min = service.findMin(customArray);

            CustomArrayValues values = new CustomArrayValues(sum, max, min);

            CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();

            warehouse.put(customArray.getId(), values);

        } catch (ArrayException e) {
            logger.error("Update failed for ID {}: {}", customArray.getId(), e.getMessage());
        }
    }
}