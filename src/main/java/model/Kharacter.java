package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> getStatsAsStrings() {
        List<String> statStrings = new ArrayList<>();
        statStrings.add("Speed: " + stats.get(Stat.SPEED));
        statStrings.add("Strength: " + stats.get(Stat.STRENGTH));
        statStrings.add("Stamina: " + stats.get(Stat.STAMINA));
        statStrings.add("Sanity: " + stats.get(Stat.SANITY));
        return statStrings;
    }

    public void updateStat(HashMap<Stat, Integer> statsToAdd) { //Jätteful metod i know
        for (Stat playerStat : stats.keySet()) {
            //stats.put(playerStat, statsToAdd.get(playerStat)); //fick hjälp av pi med denna one linern, kolla om det fungerar.
           for (Stat statToAdd : statsToAdd.keySet()) {
                if (playerStat == statToAdd)
                    stats.put(playerStat, stats.get(playerStat) + statsToAdd.get(statToAdd));
            }


        }
    }
    public void updateStatFromCombat(Stat stat, int damage){
        stats.put(stat, stats.get(stat) - damage);
    }



    public String getName() {
        return name;
    }
}

