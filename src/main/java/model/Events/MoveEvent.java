package model.Events;

import model.Player;
import model.Stat;

public class MoveEvent extends GameEvent {
    Stat statToRollOn;
    int threshHold;

    String eventText;
    int eventType;

    int deltaX;
    int deltaY;
    int deltaZ;


    public MoveEvent(int statToRollOn, int threshHold, String eventText, int deltaX, int deltaY, int deltaZ, int eventType) {
        this.statToRollOn = Stat.from(statToRollOn);
        this.threshHold = threshHold;
        this.eventText = eventText;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
        this.eventType = eventType;
    }

    @Override
    public void activate() {
      observer.updateEventView(eventType, eventText);
        System.out.println("moveEvent");
    }

    @Override
    public void handleEvent(Player currentPlayer) {
        if(threshHold > currentPlayer.rollStat(statToRollOn)) {
            currentPlayer.playerMoveEvent(deltaX,deltaY,deltaZ);
        }
        System.out.println("move event triggered");
    }

    @Override
    public int getEventType() {
        return eventType; //From XMLparser
    }
}
