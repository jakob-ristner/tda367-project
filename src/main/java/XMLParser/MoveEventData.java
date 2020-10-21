package XMLParser;

public class MoveEventData extends EventData {
    private int eventThreshold;
    private int deltaX;
    private int deltaY;
    private int deltaFloor;
    private int stat;
    private int statChange;
    boolean positiveEvent;

    MoveEventData() {
    }

    void setEventThreshold(int eventThreshold) {
        this.eventThreshold = eventThreshold;
    }

    void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    void setDeltaFloor(int deltaFloor) {
        this.deltaFloor = deltaFloor;
    }

    void setStat(int stat) {
        this.stat = stat;
    }

    void setStatChange(int statChange) {
        this.statChange = statChange;
    }

    void setPositiveEvent(boolean positiveEvent) {
        this.positiveEvent = positiveEvent;
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

    public boolean getPositiveEvent() {
        return positiveEvent;
    }


}
