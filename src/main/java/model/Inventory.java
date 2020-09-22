package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> itemList;

    public Inventory() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for(Item item: itemList)
            names.add(item.getName());
        return names;
    }
}
