package model.Events;

import model.Player;

public class GameWonEvent extends GameEvent {

    int eventType = -4;

    String eventText = "You bested the horrors of the house and escaped. Adventurer side wins!";

    public GameWonEvent() {
        super(false);
    }

    @Override
    public void activate() {
        observer.updateEventView(eventType, eventText);
    }

    @Override
    public void handleEvent(Player currentPlayer) {
        //Dummy method. Did not know how to fix before deadline.
    }

    @Override
    public int getEventType() {
        return -4;
    }

    @Override
    public String getEventEffectText() {
        return "Game has Ended, If you ended up here you have broken the game. Congratz!";
    }

    @Override
    public String getEventButtonText() {
        return "You've won the game!";
    }
}
