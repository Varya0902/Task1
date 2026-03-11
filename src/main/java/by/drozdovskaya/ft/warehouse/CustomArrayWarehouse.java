package by.drozdovskaya.ft.warehouse;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {
    private static CustomArrayWarehouse instance;

    private Map<Long, CustomArrayValues> map = new HashMap<>();

    private CustomArrayWarehouse() {}

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public void put(long id, CustomArrayValues values) {
        map.put(id, values);
    }

    public CustomArrayValues get(long id) {
        return map.get(id);
    }

    public boolean remove(long id) {
        return map.remove(id) != null;
    }
}