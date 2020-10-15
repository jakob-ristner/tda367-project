package controller;

public interface EventObserver {
    void updateEventView(int eventType, String eventText);
    void updateEventEffect();
}
