package XMLParser;

public class RollEventData extends EventData{
    private int stat;
    private int statChange;
    private int eventThreshold;

    public RollEventData(int statChange,int stat, int eventThreshold,String eventText, int id, int eventType) {
        super(eventText,eventType,id);
        this.statChange = statChange;
        this.stat = stat;
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
