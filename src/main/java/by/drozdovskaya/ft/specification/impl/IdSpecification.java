package by.drozdovskaya.ft.specification.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.specification.CustomArraySpecification;

public class IdSpecification implements CustomArraySpecification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}