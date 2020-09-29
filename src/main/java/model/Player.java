package model;
import java.util.Random;

public class Player {
    private Inventory inventory;
    public boolean isHaunted;
    public int floor;

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    private int x;
    private int y;

    public Kharacter getCharacter() {
        return character;
    }

    private Kharacter character;
    private Random dice;

    public Player() {
        inventory = new Inventory();
        dice = new Random();
    }

    public void playerMove(int [] xyChange){
        x += xyChange[0];
        y += xyChange[1];
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
    public int rollStepsDice(){
        return dice.nextInt(character.getStat(Stat.SPEED));
    }


}
