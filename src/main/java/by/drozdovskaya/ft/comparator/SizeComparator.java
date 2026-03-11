package by.drozdovskaya.ft.comparator;

import by.drozdovskaya.ft.entity.CustomArray;
import java.util.Comparator;

public class SizeComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Integer.compare(o1.getElements().length, o2.getElements().length);
    }
}