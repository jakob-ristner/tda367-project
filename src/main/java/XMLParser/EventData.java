package XMLParser;

public abstract class EventData {
    private String eventText;
    private int eventType;
    private int id;

    EventData() {

    }

    void setEventText(String eventText) {
        this.eventText = eventText;
    }

    void setEventType(int eventType) {
        this.eventType = eventType;
    }

    void setId(int id) {
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
