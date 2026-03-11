package by.drozdovskaya.ft.comparator;

import by.drozdovskaya.ft.entity.CustomArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int[] elements1 = o1.getElements();
        int[] elements2 = o2.getElements();

        // Простая проверка: если массив пустой, считаем его значение минимальным
        int val1 = (elements1.length > 0) ? elements1[0] : Integer.MIN_VALUE;
        int val2 = (elements2.length > 0) ? elements2[0] : Integer.MIN_VALUE;

        return Integer.compare(val1, val2);
    }
}