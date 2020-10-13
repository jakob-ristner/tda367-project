package model;

import java.util.HashMap;

public class ItemEvent implements Event {
    private Item item;
    private String eventText;


    public ItemEvent(Item item, String eventText) {
        this.item = item;
        this.eventText = eventText;
    }

    @Override
    public void activate(Player currentPlayer) {
        System.out.println(eventText);
        currentPlayer.addToInventory(item);
    }

    @Override
    public int getEventType() {
        return -1;
    }
}
