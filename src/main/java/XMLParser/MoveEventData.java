package XMLParser;

public class MoveEventData extends EventData {
    private double eventThreshold;
    private int deltaX;
    private int deltaY;
    private int deltaFloor;

    public MoveEventData(String eventText, String eventType, int id,int deltaX,int deltaY,int deltaFloor,double eventThreshold) {
        super(eventText, eventType, id);
        this.eventThreshold = eventThreshold;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaFloor = deltaFloor;
    }

    public double getEventThreshold() {
        return eventThreshold;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public int getDeltaFloor() {
        return deltaFloor;
    }

}
