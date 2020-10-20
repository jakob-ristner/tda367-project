package model.Events;

import model.Event;
import model.Player;

public class GameWonEvent extends GameEvent {

    int eventType = -4;
    String eventText = "The game has been won my friend. You and your team are the lucky winners!";

    public GameWonEvent() {
        super(false);
    }

    @Override
    public void activate() {
        //observer.updateEventView(eventType, eventText);
    }

    @Override
    public void handleEvent(Player currentPlayer) {
        //Dummy method.
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
