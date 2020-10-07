package XMLParser;

public abstract class EventData {
    private String eventText;
    private String eventType;
    private int id;

    public EventData(String eventText, String eventType, int id) {
        this.eventText = eventText;
        this.eventType = eventType;
        this.id = id;
    }

    public String getEventText() {
        return eventText;
    }

    public String getEventType() {
        return eventType;
    }

    public int getId() {
        return id;
    }
}
