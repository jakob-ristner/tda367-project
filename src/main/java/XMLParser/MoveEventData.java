package XMLParser;

public class MoveEventData extends EventData {
    private int eventThreshold;
    private int deltaX;
    private int deltaY;
    private int deltaFloor;
    private int stat;
    private int statChange;

    public MoveEventData(int stat,int statChange,String eventText, int eventType, int id, int deltaX, int deltaY, int deltaFloor, int eventThreshold) {
        super(eventText, eventType, id);
        this.eventThreshold = eventThreshold;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaFloor = deltaFloor;
        this.stat = stat;
        this.statChange = statChange;
    }

    public int getStat() {
        return stat;
    }

    public int getStatChange() {
        return statChange;
    }

    public int getEventThreshold() {
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