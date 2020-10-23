package XMLParser;

public class RollEventData extends EventData {
    private int stat;
    private int statChange;
    private int eventThreshold;

    RollEventData() {
    }

    public int getStat() {
        return stat;
    }

    void setStat(int stat) {
        this.stat = stat;
    }

    public int getStatChange() {
        return statChange;
    }

    void setStatChange(int statChange) {
        this.statChange = statChange;
    }

    public int getEventThreshold() {
        return eventThreshold;
    }

    void setEventThreshold(int eventThreshold) {
        this.eventThreshold = eventThreshold;
    }
}
