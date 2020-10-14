package model;

import utilities.Coord;

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
    public void activate(Player currentPlayer) {
      /*if(threshHold > currentPlayer.rollStat(statToRollOn)) {
            currentPlayer.playerMoveEvent(deltaX,deltaY,deltaZ);
        }
        System.out.println("move event triggered"); */
      observer.updateEventView(eventType, eventText);
        System.out.println("moveEvent");
    }

    @Override
    public int getEventType() {
        return eventType; //From XMLparser
    }
}
