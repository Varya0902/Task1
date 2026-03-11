package by.drozdovskaya.ft.comparator;

import by.drozdovskaya.ft.entity.CustomArray;
import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}