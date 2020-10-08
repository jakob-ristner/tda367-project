package model;

import java.util.HashMap;

public class ItemEvent implements Event {
    Item item;

    public ItemEvent(Item item) {
        this.item = item;
    }

    @Override
    public void activate(Player currentPlayer) {
        currentPlayer.addToInventory(item);
    }

    @Override
    public int getEventType() {
        return -1;
    }
}
