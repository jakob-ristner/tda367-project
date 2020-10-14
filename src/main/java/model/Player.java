package model;

import utilities.Coord;

import java.util.List;
import java.util.Random;

public class Player {
    private int stepsLeft;
    private int steps;
    private boolean hasCharacter;
    private boolean isHaunted;
    private boolean isDead;

    private final Inventory inventory;
    private Coord pos;
    private Kharacter character;
    private final Random dice;

    public Player() {
        inventory = new Inventory();
        dice = new Random();
    }

    int getFloor() {
        return pos.getFloor();
    }

    int getY() {
        return pos.getY();
    }

    int getX() {
        return pos.getX();
    }

    Coord getPos() {
        return pos;
    }

    void setPos(Coord pos) {
        this.pos = pos;
        this.pos.sanityCheck();
    }

    void addCoord(Coord coord) {
        //imagine it like a + operator
        pos.add(coord);
        System.out.println(getFloor());
    }

    Kharacter getCharacter() {
        return character;
    }

    boolean getHasCharacter() {
        return hasCharacter;
    }

    void setCharacter(Kharacter character) {
        this.character = character;
        hasCharacter = true;
        steps = character.getStat(Stat.SPEED);
        resetSteps();
    }

    boolean isPlayerDead() {
        for (int playerStat : character.getStats().values()) {
            if (playerStat <= 0) return true;
        }
        return false;
    }

    void playerMove(int dx, int dy) {
        pos.move(dx, dy);
        step();
    }

    void playerMoveEvent(int dx, int dy, int dz) {
        this.addCoord(new Coord(dx, dy, dz));
    }

    void addToInventory(Item item) {
        inventory.addItem(item);
        character.updateStat(item.getStats());
    }

    int rollStat(Stat stat) {
        return dice.nextInt(character.getStat(stat));
    }

    void resetSteps() {
        stepsLeft = dice.nextInt(steps + 1);
    }

    void step() {
        stepsLeft--;
    }

    int getStepsLeft() {
        return stepsLeft;
    }


    String getCharacterName() {
        return character.getName();
    }

    void setHauntedPlayer() {
        isHaunted = true;
    }

    boolean isHaunted() {
        return isHaunted;
    }

    List<String> getCharacterStatsAsStrings() {
        return character.getStatsAsStrings();
    }

    List<String> getItemNames() {
        return inventory.getNames();
    }
}
