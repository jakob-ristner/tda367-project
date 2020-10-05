package model;
import java.util.Random;

public class Player {
    private Inventory inventory;
    private boolean isHaunted = false;

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

    public boolean hasCharacter;

    private int steps;


    public Kharacter getCharacter() {
        return character;
    }

    private Kharacter character;
    private Random dice;
    private boolean isDead;

    public Player() {
        inventory = new Inventory();
        dice = new Random();
        hasCharacter = false;
    }
    public boolean isPlayerDead(){
        for (int playerStat : character.getStats().values()){
            if( playerStat <= 0) return true;
        }
        return false;
    }

    public boolean isDead() {
        return isDead;
    }

    public void playerMove(int [] xyChange){
        x += xyChange[0];
        y += xyChange[1];
    }

    public void addToInventory(Item item) {
        inventory.addItem(item);
        character.updateStat(item.getStats());
    }

    public boolean isEventPassed(Stat stat, int threshhold) {
        int statToRoll = character.getStat(stat);
        int roll = dice.nextInt(statToRoll + 1);
        return roll > threshhold;
    }

    public int rollStat(Stat stat){
        return dice.nextInt(character.getStat(stat));
    }


    public void setCharacter(Kharacter character) {
        this.character = character;
        hasCharacter = true;
    }
    public void setStepAmount(){
        steps = dice.nextInt(character.getStat(Stat.SPEED));
    }


    public int getStepAmount() {
        return steps;
    }

    public String getCharacterName() {
        return character.getName();
    }

    public void setHauntedPlayer(){
        isHaunted = true;
    }

    public boolean isHaunted() {
        return isHaunted;
    }
}
