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
        character.updateStat(item.getStats());
    }

    public boolean rollDice(Stat stat, int threshhold) {
        int statToRoll = character.getStat(stat);
        int roll = dice.nextInt(statToRoll + 1);
        return roll > threshhold;
    }

    public void setCharacter(Kharacter character) {
        this.character = character;
    }


}
