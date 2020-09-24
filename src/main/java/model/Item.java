package model;

import java.util.HashMap;

public class Item {
    private String name;
    private HashMap<Stat, Integer> stats;

    public Item(String name,Stat stat, int statIncrease) {
        stats = new HashMap<>();
        stats.put(stat, statIncrease);
        this.name = name;
    }

    public HashMap<Stat, Integer> getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

}
