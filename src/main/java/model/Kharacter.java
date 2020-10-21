package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kharacter {

    private String name;
    private HashMap<Stat, Integer> stats;


    /**
     *
     * @param name Name of character
     * @param statValue The arraylist is used for refactoring our hashmap. Using the index 'i' in order to get
     * the key(stat) and statValue[i] to get the Integer.
     */

    Kharacter(String name, int[] statValue) {
        stats=new HashMap<>();
        for(int i = 0; i<statValue.length;i++) {
            stats.put(Stat.from(i), statValue[i]);
        }
        this.name = name;
    }

    HashMap<Stat, Integer> getStats() {
        return stats;
    }

    int getStat(Stat stat) {
        return stats.get(stat);
    }

    /**
     * @return strings to represent stats in view
     */
    List<String> getStatsAsStrings() {
        List<String> statStrings = new ArrayList<>();
        statStrings.add("Speed: " + stats.get(Stat.SPEED));
        statStrings.add("Strength: " + stats.get(Stat.STRENGTH));
        statStrings.add("Stamina: " + stats.get(Stat.STAMINA));
        statStrings.add("Sanity: " + stats.get(Stat.SANITY));
        return statStrings;
    }

    /**
     * adds to Stat hashmaps together
     * @param statsToAdd can be stats of an item etc
     */
    public void updateStat(HashMap<Stat, Integer> statsToAdd) { //Jätteful metod i know
        for (Stat playerStat : stats.keySet()) {
            for (Stat statToAdd : statsToAdd.keySet()) {
                if (playerStat == statToAdd)
                    stats.put(playerStat, stats.get(playerStat) + statsToAdd.get(statToAdd));
                System.out.println("STATS UPDATED");
            }
        }
    }

    /**
     * used to parse combat damage to statChange
     * @param stat
     * @param damage
     */
    void updateStatFromCombat(Stat stat, int damage) {
        int oldv = stats.get(stat);
        stats.put(stat, oldv-damage);
    }


    String getName() {
        return name;
    }
}

