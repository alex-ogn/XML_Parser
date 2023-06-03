package Utilities;

import java.util.HashMap;
import java.util.Map;

public class ElementIdGenerator {
    private int counter;
    private Map<String, Integer> idCounts;

    public ElementIdGenerator() {
        this.counter = 1;
        this.idCounts = new HashMap<>();
    }

    public String generateId(String id) {
        if (id != null) {
            int count = idCounts.getOrDefault(id, 0);
            idCounts.put(id, count + 1);
            if (count > 0) {
                return id + "_" + count;
            }
            return id;
        }
        id = new String("" + counter++);
        idCounts.put(id, 1);
        return id;
    }

    public String generateId() {
        return generateId(null);
    }
}
