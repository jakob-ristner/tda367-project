package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory is a space for items that is carried by the player.
 */
public class Inventory {
    private List<Item> itemList;

    public Inventory() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * @return names of all items on inventory
     */
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for(Item item: itemList)
            names.add(item.getName());
        return names;
    }
}
