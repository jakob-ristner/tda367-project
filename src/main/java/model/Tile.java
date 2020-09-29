package model;

public class Tile {
    private Event event;
    private boolean illuminated = false;
    private boolean doorUp = true;
    private boolean doorDown = true;
    private boolean doorLeft = true;
    private boolean doorRight = true;


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

    public boolean hasEvent(){
        return event!= null;
    }

    public void toggleIllumination(){
        illuminated = !illuminated;
    }

    public void setEvent(Event event){
        this.event = event;
    }
}
