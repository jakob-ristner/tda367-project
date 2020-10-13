package model;

import utilities.Coord;

public class MoveEvent implements Event {
    Stat statToRollOn; //TODO: Fix so that this isn't a string but instead is an Enum
    int threshHold;
    String eventText;

    int deltaX;
    int deltaY;
    int deltaZ;

    public MoveEvent(int statToRollOn, int threshHold, String eventText, int deltaX, int deltaY, int deltaZ) {
        this.statToRollOn = Stat.from(statToRollOn);
        this.threshHold = threshHold;
        this.eventText = eventText;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
    }

    @Override
    public void activate(Player currentPlayer) {
      if(threshHold > currentPlayer.rollStat(statToRollOn)) {
            currentPlayer.playerMoveEvent(deltaX,deltaY,deltaZ);
        }
        System.out.println("move event triggered");
    }

    @Override
    public int getEventType() {
        return -3; //for xml parser
    }
}
