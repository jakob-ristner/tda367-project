package model;

import java.util.HashMap;

public class Kharacter {

    private String name;
    private HashMap<Stat, Integer> stats;

    public Kharacter(HashMap<Stat, Integer> stats, String name) {
        this.stats = stats;
        this.name = name;
    }

    public HashMap<Stat, Integer> getStats() {
        return stats;
    }
    public int getStat(Stat stat) {
        return stats.get(stat);
    }


    public void updateStat(HashMap<Stat, Integer> statsToAdd) { //Jätte ful metod i know
        for (Stat playerStat : stats.keySet()) {
            for (Stat statToAdd : statsToAdd.keySet()) {
                if (playerStat == statToAdd)
                    stats.put(playerStat, stats.get(playerStat) + statsToAdd.get(statToAdd));
            }
        }
    }

    public String getName() {
        return name;
    }
}

