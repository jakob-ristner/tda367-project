package model;

import java.util.HashMap;

public class Item {
    private String name;
    private String pickupText;
    private HashMap<Stat, Integer> stats;

    public Item(String name, HashMap<Stat, Integer> stats) {
        this.name = name;
        this.stats = stats;
        setPickupText();
    }

    public HashMap<Stat, Integer> getStats() {
        return stats;
    }

    public int getStat(Stat stat) {
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

    private void setPickupText() {
       pickupText = "\n";
       for (Stat stat: stats.keySet()) {
           if(stats.get(stat) != 0) {
               pickupText += (stat.toString().toLowerCase() + ": " + stats.get(stat) + "\n");
           }
       }
    }



}
