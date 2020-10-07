package XMLParser;

public class ItemEventData extends EventData{
    private int stamina;
    private int strength;
    private int speed;
    private int sanity;

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

    public ItemEventData(int stamina, int strength, int speed, int sanity, String eventText, int id, String eventType) {
        super(eventText, eventType, id);
        this.stamina = stamina;
        this.strength = strength;
        this.speed = speed;
        this.sanity = sanity;

    }
}
