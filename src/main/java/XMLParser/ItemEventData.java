package XMLParser;

public class ItemEventData extends EventData {
    private int stamina;
    private int strength;
    private int speed;
    private int sanity;
    private String itemName;

    ItemEventData() {

    }

    public int getStamina() {
        return stamina;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSanity() {
        return sanity;
    }

    void setSanity(int sanity) {
        this.sanity = sanity;
    }

    public String getItemName() {
        return itemName;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
