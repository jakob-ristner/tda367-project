package model;

import java.util.HashMap;

public class Kharacter {

    private String name;
    HashMap<Stat, Integer> stats;

    public Kharacter(int speed, int strength, int sanity, int stamina, String name) {

        stats = new HashMap<>();
        stats.put(Stat.SPEED, speed);
        stats.put(Stat.STRENGTH, strength);
        stats.put(Stat.SANITY, sanity);
        stats.put(Stat.STAMINA, stamina);


    }

    public HashMap<Stat, Integer> getStats() {
        return stats;
    }
    public int getStat(Stat stat) {
        return stats.get(stat);
    }


    //Deprecated methods
    public int getSpeed() {
        return stats.get(Stat.SPEED);
    }

    public int getStrength() {
        return stats.get(Stat.STRENGTH);
    }

    public int getSanity() {
        return stats.get(Stat.SANITY);
    }

    public int getStamina() {
        return stats.get(Stat.STAMINA);
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

