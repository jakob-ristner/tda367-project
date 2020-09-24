package model;

import java.util.HashMap;

public class Item {
    private String name;
    private Stat stat;
    private int statIncrease;
    private HashMap<Stat, Integer> stats;

    public Item(String name,Stat stat, int statIncrease) {
        this.stat = stat;
        this.statIncrease = statIncrease;
        this.name = name;

        stats = new HashMap<>();
        stats.put(stat, statIncrease);

    }

    public HashMap<Stat, Integer> getStats() {
        return stats;
    }

    public int getStatIncrease() {
        return statIncrease;
    }

    public String getName() {
        return name;
    }

}
