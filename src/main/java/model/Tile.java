package model;

public class Tile {
    private Event event;
    private boolean illuminated = false;

    public Tile(){

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
