package XMLParser;

public class ItemEventData extends EventData{
    private int stamina;
    private int strength;
    private int speed;
    private int sanity;
    private String itemName;

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSanity() {
        return sanity;
    }

    public String getItemName(){
        return itemName;
    }

    public ItemEventData(int stamina, int strength, int speed, int sanity, String eventText, int id, int eventType, String itemName) {
        super(eventText, eventType, id);
        this.stamina = stamina;
        this.strength = strength;
        this.speed = speed;
        this.sanity = sanity;
        this.itemName = itemName;

    }
}
