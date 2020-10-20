package model.Events;

import model.Player;
import model.Item;

public class ItemEvent extends GameEvent {
    private Item item;
    private String eventText;
    private int eventType;
    private String effectText;
    private String eventButtonText;

    public ItemEvent(Item item, String eventText, int eventType) {
        super(false);
        this.item = item;
        this.eventText = eventText;
        this.eventText += item.getPickupText();
        this.eventType = eventType;
    }


    /**
     * Activates the event. Sets the eventButtonText and then tells the observer to update the view.
     */
    @Override
    public void activate() {
        eventButtonText = "Bring " + item.getName() + "!";
        observer.updateEventView(eventType, eventText);
        System.out.print("ItemEvent");
    }

    /**
     * The eventhandler. Adds an item to the players inventory and sets the text for what has happened.
     * @param currentPlayer
     */
    @Override
    public void handleEvent(Player currentPlayer){
        currentPlayer.addToInventory(item);
        effectText = "You obtained " + item.getName();
        observer.updateEventEffect();
    }

    /**
     *
     * @return Integer representation of the eventType
     */
    @Override
    public int getEventType() {
        return eventType;
    }

    @Override
    public String getEventEffectText() {
        return effectText;
    }

    @Override
    public String getEventButtonText() {
        return eventButtonText;
    }


}
