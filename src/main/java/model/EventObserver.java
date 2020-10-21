package model;

public interface EventObserver {
    void updateEventView(int eventType, String eventText);
    void updateEventEffect();
}
