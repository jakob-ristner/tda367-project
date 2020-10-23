package model;

import java.util.HashMap;

/**
 * Items can be equipped by a player and has stats as an attribute.
 */
public class Item {
    private final String name;
    private String pickupText;
    private final HashMap<Stat, Integer> stats;

    public Item(String name, HashMap<Stat, Integer> stats) {
        this.name = name;
        this.stats = stats;
        setPickupText();
    }

    HashMap<Stat, Integer> getStats() {
        return stats;
    }

    int getStat(Stat stat) {
        return stats.get(stat);
    }

    public String getName() {
        return name;
    }

    /**
     * @return text to be shown in view on pickup
     */
    public String getPickupText() {
        return pickupText;
    }

    /**
     * creates the text for the pick up prompt
     */
    private void setPickupText() {
        pickupText = "\n";
        for (Stat stat : stats.keySet()) {
            if (stats.get(stat) != 0) {
                pickupText += (stat.toString().toLowerCase() + ": " + stats.get(stat) + "\n");
            }
        }
    }


}
