package XMLParser;

public class MoveEventData extends EventData {
    boolean positiveEvent;
    private int eventThreshold;
    private int deltaX;
    private int deltaY;
    private int deltaFloor;
    private int stat;
    private int statChange;

    MoveEventData() {
    }

    void setStatChange(int statChange) {
        this.statChange = statChange;
    }

    public int getStat() {
        return stat;
    }

    void setStat(int stat) {
        this.stat = stat;
    }

    public int getEventThreshold() {
        return eventThreshold;
    }

    void setEventThreshold(int eventThreshold) {
        this.eventThreshold = eventThreshold;
    }

    public int getDeltaX() {
        return deltaX;
    }

    void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public int getDeltaFloor() {
        return deltaFloor;
    }

    void setDeltaFloor(int deltaFloor) {
        this.deltaFloor = deltaFloor;
    }

    public boolean getPositiveEvent() {
        return positiveEvent;
    }

    void setPositiveEvent(boolean positiveEvent) {
        this.positiveEvent = positiveEvent;
    }


}
