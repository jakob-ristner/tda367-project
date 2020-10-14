package model;

public class ItemEvent implements Event {
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
        System.out.println(eventText);
        currentPlayer.addToInventory(item);
    }

    @Override
    public int getEventType() {
        return eventType;
    }
}
