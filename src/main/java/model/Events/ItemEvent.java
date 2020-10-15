package model.Events;

import model.Item;
import model.Player;

public class ItemEvent extends GameEvent {
    private Item item;
    private String eventText;
    private int eventType;
    private String effectText;


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
