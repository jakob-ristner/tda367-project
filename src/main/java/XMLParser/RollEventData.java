package XMLParser;

public class RollEventData extends EventData{
    private String stat;
    private int statChange;
    private int eventThreshold;

    public RollEventData(int statChange,String stat, int eventThreshold,String eventText, int id, int eventType) {
        super(eventText,eventType,id);
        this.statChange = statChange;
        this.stat = stat;
        this.eventThreshold = eventThreshold;
    }

    public String getStat() {
        return stat;
    }

    public int getStatChange() {
        return statChange;
    }

    public int getEventThreshold() {
        return eventThreshold;
    }
}
