package model;

import controller.EventObserver;

public interface Event {

    void activate();

    void handleEvent(Player currentPlayer);

    void setObserver(EventObserver observer);

    int getEventType(); //for xml parser

    boolean isPermanent();

    String getEventEffectText();

    String getEventButtonText();

}
