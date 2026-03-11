package by.drozdovskaya.ft.repository.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.repository.CustomArrayRepository;
import by.drozdovskaya.ft.specification.CustomArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    private static CustomArrayRepositoryImpl instance;
    private final List<CustomArray> arrays = new ArrayList<>();

    private CustomArrayRepositoryImpl() {}

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(CustomArray array) {
        arrays.add(array);
    }

    @Override
    public void remove(CustomArray array) {
        arrays.remove(array);
    }


    @Override
    public List<CustomArray> query(CustomArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray array : arrays) {
            if (specification.specify(array)) {
                result.add(array);
            }
        }
        return result;
    }

    @Override
    public List<CustomArray> sort(Comparator<? super CustomArray> comparator) {
        return arrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}