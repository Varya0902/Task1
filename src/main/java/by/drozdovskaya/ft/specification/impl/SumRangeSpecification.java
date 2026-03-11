package by.drozdovskaya.ft.specification.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.specification.CustomArraySpecification;
import by.drozdovskaya.ft.warehouse.CustomArrayValues;
import by.drozdovskaya.ft.warehouse.CustomArrayWarehouse;

public class SumRangeSpecification implements CustomArraySpecification {
    private final int min;
    private final int max;

    public SumRangeSpecification(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray array) {
        CustomArrayValues values = CustomArrayWarehouse.getInstance().get(array.getId());
        if (values == null) {
            return false;
        }
        int currentSum = values.getSum();
        return currentSum >= min && currentSum <= max;
    }
}