package model.Events;

import model.Player;
import model.Item;

public class ItemEvent extends GameEvent {
    private Item item;
    private String eventText;
    private int eventType;
    private String effectText;

    public ItemEvent(Item item, String eventText, int eventType) {
        super(false);
        this.item = item;
        this.eventText = eventText;
        this.eventText += item.getPickupText();
        this.eventType = eventType;
    }

    @Override
    public void activate() {
        observer.updateEventView(eventType, eventText);
        System.out.print("ItemEvent");
    }

    @Override
    public void handleEvent(Player currentPlayer){
        currentPlayer.addToInventory(item);
        effectText = "You obtained " + item.getName();
        observer.updateEventEffect();
    }

    @Override
    public int getEventType() {
        return eventType;
    }

    @Override
    public String getEventEffectText() {
        return effectText;
    }



}
