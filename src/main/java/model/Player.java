package model;
import java.util.Random;

public class Player {
    private Inventory inventory;
    private Kharacter character;
    private Random dice;

    public Player() {
        inventory = new Inventory();
        dice = new Random();
    }

    public void addToInventory(Item item) {
        inventory.addItem(item);
        character.updateStat(item.getStat(), item.getStatIncrease());
    }

    public boolean rollDice(Stat stat, int threshhold) {
        int statToRoll = 0;
        switch (stat) {
            case STRENGTH:
                statToRoll = character.getStrength();
                break;
            case STAMINA:
                statToRoll = character.getStamina();
                break;
            case SANITY:
                statToRoll = character.getSanity();
                break;
            case SPEED:
                statToRoll = character.getSpeed();
                break;
            default:
                break;
        }
        int roll = dice.nextInt(statToRoll + 1);
        return roll > threshhold;
    }

    public void setCharacter(Kharacter character) {
        this.character = character;
    }
}
