package XMLParser;

public class RollEventData extends EventData{
    private int stat;
    private int statChange;
    private int eventThreshold;

    RollEventData() {
    }

    void setStat(int stat) {
        this.stat = stat;
    }

    void setStatChange(int statChange) {
        this.statChange = statChange;
    }

    void setEventThreshold(int eventThreshold) {
        this.eventThreshold = eventThreshold;
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
}
