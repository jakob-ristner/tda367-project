package model;

import java.util.HashMap;
import java.util.Map;

public enum Stat {
    SPEED(0), STRENGTH(1), SANITY(2), STAMINA(3);

    public final int value;

    Stat(int value) {
        this.value = value;
    }
    private static final Map<Integer, Stat> statValues = new HashMap<>();
        static
    {
        for (Stat Stat : Stat.values())
            statValues.put(Stat.value, Stat);
    }
    public static Stat from(int value)
    {
        return statValues.get(value);
    }

}
