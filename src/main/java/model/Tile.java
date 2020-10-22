package model;


import java.util.HashMap;


/**
 * Class representing a room or a Tile on the board. Has doors to other rooms and holds events and holds stairs.
 */
public class Tile {
    private Event event;

    private boolean doorUp = true;
    private boolean doorDown = true;
    private boolean doorLeft = true;
    private boolean doorRight = true;

    private boolean hasEvent;
    private boolean stairUp;
    private boolean stairDown;
    private boolean hasStair;


    Tile(int i, int j, Tile[][] tiles) {
        hasEvent = false;
        setDoors(i, j, tiles);
    }

    void setStairUp(boolean stairUp) {
        this.stairUp = stairUp;
        hasStair = true;
    }

    void setStairDown(boolean stairDown) {
        this.stairDown = stairDown;
        hasStair = true;
    }

    boolean hasStairUp() {
        return stairUp;
    }

    boolean hasStairDown() {
        return stairDown;
    }

    boolean hasStair() {
        return hasStair;
    }

    private void setDoors(int col, int row, Tile[][] tiles) {
        if (row == 0) doorUp = false;
        if (col == 0) doorLeft = false;
        if (row == tiles.length - 1) doorDown = false;
        if (col == tiles[0].length - 1) doorRight = false;

    }


    boolean hasEvent() {
        return hasEvent;
    }


    void setEvent(Event event) {
        hasEvent = true;
        this.event = event;
    }

    /**
     * HashMap so that doors is easily accessible through an int
     *
     * @return Hashmap
     */
    HashMap<Integer, Boolean> getDoors() {
        HashMap<Integer, Boolean> doors = new HashMap<>();
        doors.put(0, doorUp);
        doors.put(1, doorRight);
        doors.put(2, doorDown);
        doors.put(3, doorLeft);
        return doors;
    }

    /**
     * If there exists an event on this tile then this method activates the event.
     *
     * @return True if it succeds in activating the event and false if it doesn't.
     */
    boolean tryActivateEvent() {
        if (hasEvent) {
            event.activate();
            return true;
        }
        return false;
    }

    /**
     * Handles an event with the player as a parameter, if it is not a permanent event it  will disappear
     *
     * @param currentPlayer player that enters the tile
     */

    void handleEvent(Player currentPlayer) {
        event.handleEvent(currentPlayer);
    }

    /**
     * Getter for the event's buttonText.
     *
     * @return String to be displayed on eventView.
     */
    String getEventButtonText() {
        return event.getEventButtonText();
    }

    /**
     * Getter for the event's outcome text
     *
     * @return String to be displayed on mainGameView.
     */
    String getEventEffectText() {
        String effectText = event.getEventEffectText();
        if (!event.isPermanent()) {
            event = null;
            hasEvent = false;
        }
        return effectText;

    }
}
