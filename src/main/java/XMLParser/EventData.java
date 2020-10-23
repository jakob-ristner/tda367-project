package XMLParser;

public abstract class EventData {
    private String eventText;
    private int eventType;
    private int id;

    EventData() {

    }

    void setId(int id) {
        this.id = id;
    }

    public String getEventText() {
        return eventText;
    }

    void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public int getEventType() {
        return eventType;
    }

    void setEventType(int eventType) {
        this.eventType = eventType;
    }


}
