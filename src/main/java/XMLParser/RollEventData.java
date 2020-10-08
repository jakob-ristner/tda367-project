package XMLParser;

public class RollEventData extends EventData{
    private String stat;
    private int statChange;
    private double eventThreshold;

    public RollEventData(int statChange,String stat, double eventThreshold,String eventText, int id, int eventType) {
        super(eventText,eventType,id);
        this.statChange = statChange;
        this.stat = stat;
    }

    public String getStat() {
        return stat;
    }

    public int getStatChange() {
        return statChange;
    }

    public double getEventThreshold() {
        return eventThreshold;
    }
}
