package model;

import java.util.HashMap;

public class Tile {
    private Event event;
    private boolean illuminated = false;
    private boolean doorUp = true;
    private boolean doorDown = true;
    private boolean doorLeft = true;
    private boolean doorRight = true;
    private boolean hasPlayer;


    public Tile(int i, int j, Tile[][] tiles){
        setDoors(i,j,tiles);
    }
    private void setDoors(int col, int row, Tile[][] tiles){
        if (row == 0) doorUp = false;
        if (col == 0) doorLeft = false;
        if (row == tiles.length) doorDown = false;
        if (col == tiles[0].length) doorRight = false;

    }

    public void activate(){
        event.activate();
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public boolean hasEvent(){
        return event!= null;
    }

    public void toggleIllumination(){
        illuminated = !illuminated;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public HashMap<Integer, Boolean> getDoors() {
        HashMap<Integer, Boolean> doors = new HashMap<>();
        doors.put(0, doorUp);
        doors.put(1, doorRight);
        doors.put(2, doorDown);
        doors.put(3, doorLeft);
        return doors;
    }
}
