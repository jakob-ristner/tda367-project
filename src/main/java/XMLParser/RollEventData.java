package XMLParser;

public class RollEventData extends EventData{
    private int stamina;
    private int strength;
    private int speed;
    private int sanity;
    private double eventThreshold;

    public RollEventData(int stamina, int strength, int speed, int sanity, double eventThreshold,String eventText, int id, int eventType) {
        super(eventText,eventType,id);
        this.stamina = stamina;
        this.strength = strength;
        this.speed = speed;
        this.sanity = sanity;
        this.eventThreshold = eventThreshold;
    }

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

    public double getEventThreshold() {
        return eventThreshold;
    }
}
