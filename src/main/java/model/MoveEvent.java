package model;

import utilities.Coord;

public class MoveEvent implements Event {
    Coord coordDelta;
    Stat statToRollOn;
    int threshHold;

    public MoveEvent(Coord coordDelta, Stat statToRollOn, int threshHold) {
        this.coordDelta = coordDelta;
        this.statToRollOn = statToRollOn;
        this.threshHold = threshHold;
    }

    @Override
    public void activate(Player currentPlayer) {
        //player.getstat * threshold ???????????????????????????????
        if(threshHold > currentPlayer.rollStat(statToRollOn)) {
            currentPlayer.addCoord(coordDelta);
        }
        System.out.println("move event triggered");
    }

    @Override
    public int getEventType() {
        return -3; //for xml parser
    }
}
