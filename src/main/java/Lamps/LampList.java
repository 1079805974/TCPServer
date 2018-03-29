package Lamps;

import java.util.HashMap;
import java.util.Map;

public class LampList {
    private Map<String, Lamp> list = new HashMap<>();

    private static LampList instance = new LampList();

    public static LampList getInstance() {
        return instance;
    }

    public void put(String id, Lamp l) {
        list.put(id, l);
    }

    public int size() {
        return list.size();
    }

    public Lamp get(String id) {
        return list.get(id);
    }

    public void remove(String id) {
        list.remove(id);
    }

    @Override
    public String toString() {
        return list.toString();
    }


}
