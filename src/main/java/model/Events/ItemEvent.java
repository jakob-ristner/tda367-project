package model.Events;

import model.Item;
import model.Player;

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
    public void activate() {
        observer.updateEventView(eventType, eventText);
        System.out.print("ItemEvent");
    }

    @Override
    public void handleEvent(Player currentPlayer) {
        currentPlayer.addToInventory(item);
    }


    @Override
    public int getEventType() {
        return eventType;
    }
}
