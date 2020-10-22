package model;

/**
 * All events implements this interface
 * activate() Tells the eventView to activate
 * handleEvents(Player currentPlayer) is what the event does to a player.
 */
public interface Event {

    void activate();

    void handleEvent(Player currentPlayer);

    void setObserver(EventObserver observer);

    int getEventType();

    boolean isPermanent();

    String getEventEffectText();

    String getEventButtonText();

}
