package model;
import utilities.Coord;

import java.util.List;
import java.util.Random;

public class Player {
    private Inventory inventory;
    private boolean isHaunted = false;
    private Coord pos;
    private Kharacter character;
    private Random dice;
    int stepsLeft;
    int steps;
    private boolean isDead;
    public boolean hasCharacter;

    public int floor;

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return pos.getFloor();
    }

    public int getY() {
        return pos.getY();
    }

    public int getX() {
        return pos.getX();
    }

    public void setPos(Coord pos) {
        this.pos = pos;
        this.pos.sanityCheck();
    }

    public Coord getPos() {
        return pos;
    }

    public void addCoord(Coord coord) {
        //imagine it like a + operator
        pos.add(coord);
        System.out.println(getFloor());
    }




    public Kharacter getCharacter() {
        return character;
    }


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

    public void playerMove(int dx, int dy){
        pos.move(dx, dy);
        step();
    }
    public void playerMoveEvent(int dx, int dy, int dz){
        this.addCoord(new Coord(dx,dy,dz));
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
        steps = character.getStat(Stat.SPEED);
        resetSteps();
    }

    public void resetSteps() {
        stepsLeft = dice.nextInt(steps + 1);
    }

    public void step() {
        stepsLeft--;
    }

    public int getStepsLeft() {
        return stepsLeft;
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

    public List<String> getCharacterStatsAsStrings() {
        return character.getStatsAsStrings();
    }

    public List<String> getItemNames() {
        return inventory.getNames();
    }
}
