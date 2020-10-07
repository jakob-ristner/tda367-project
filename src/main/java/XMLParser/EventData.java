package XMLParser;

public abstract class EventData {
    private String eventText;
    private int eventType;
    private int id;

    public EventData(String eventText, int eventType, int id) {
        this.eventText = eventText;
        this.eventType = eventType;
        this.id = id;
    }

    public String getEventText() {
        return eventText;
    }

    public int getEventType() {
        return eventType;
    }

    public int getId() {
        return id;
    }
}
