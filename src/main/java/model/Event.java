package model;

import controller.EventObserver;

public interface Event {
    void activate();

    void handleEvent(Player currentPlayer);

    void setObserver(EventObserver observer);

    int getEventType(); //for xml parser

    //TODO: Let events subscribe to controllerObservable?? Isf låt activate i eventet skicka all den relevanta infon ut
    //TODO: till controllern som delegerar det vidare till den korrekta vyn. Smidig lösning?
}
