package model;

public interface Event {
    void activate(Player currentPlayer);

    int getEventType(); //for xml parser

}
