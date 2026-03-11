package by.drozdovskaya.ft.repository;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.specification.CustomArraySpecification;
import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {
    void add(CustomArray array);
    void remove(CustomArray array);

    List<CustomArray> query(CustomArraySpecification specification);

    List<CustomArray> sort(Comparator<? super CustomArray> comparator);
}