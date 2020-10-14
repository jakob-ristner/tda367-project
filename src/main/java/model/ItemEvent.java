package model;

import java.util.HashMap;

public class ItemEvent extends GameEvent {
    private Item item;
    private String eventText;
    private int eventType;


    public ItemEvent(Item item, String eventText, int eventType) {
        this.item = item;
        this.eventText = eventText;
        this.eventType = eventType;
    }

    @Override
    public void activate(Player currentPlayer) {
        /*System.out.println(eventText);
        currentPlayer.addToInventory(item);*/
        observer.updateEventView(eventType, eventText);
    }

    @Override
    public int getEventType() {
        return eventType;
    }
}
