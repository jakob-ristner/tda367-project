package model.Events;

import model.Player;
import model.Stat;
import utilities.Coord;

public class MoveEvent extends GameEvent {
    Stat statToRollOn;
    int threshHold;

    String eventText;
    int eventType;
    private String effectText;

    int deltaX;
    int deltaY;
    int deltaZ;

    Coord coord;


    public MoveEvent(int statToRollOn, int threshHold, String eventText, int deltaX, int deltaY, int deltaZ, int eventType) {
        this.statToRollOn = Stat.from(statToRollOn);
        this.threshHold = threshHold;
        this.eventText = eventText;
        coord = new Coord(deltaX,deltaY,deltaZ);
        this.eventType = eventType;
    }

    @Override
    public void activate() {
      observer.updateEventView(eventType, eventText);
        System.out.println("moveEvent");
    }

    @Override
    public void handleEvent(Player currentPlayer) {
        if(threshHold > currentPlayer.rollStat(statToRollOn)) {//TODO: Fix so that we have 2 scenarios coming from the xml parser. One negative and one positive.
            effectText = "TESTING";
            observer.updateEventEffect();
            currentPlayer.addCoord(coord);
        }

        System.out.println("move event triggered");
    }

    @Override
    public int getEventType() {
        return eventType; //From XMLparser
    }

    @Override
    public String getEventEffectText() {
        return effectText;
    }
}
