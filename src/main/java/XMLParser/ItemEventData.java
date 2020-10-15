package XMLParser;

public class ItemEventData extends EventData{
    private int stamina;
    private int strength;
    private int speed;
    private int sanity;
    private String itemName;

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    void setStrength(int strength) {
        this.strength = strength;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    void setSanity(int sanity) {
        this.sanity = sanity;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getItemName(){
        return itemName;
    }

    ItemEventData() {

    }
}
