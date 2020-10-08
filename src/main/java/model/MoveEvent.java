package model;

import utilities.Coord;

public class MoveEvent implements Event {
    Coord newCoord;
    Stat statToRollOn;
    int threshHold;

    public MoveEvent(Coord newCoord, Stat statToRollOn, int threshHold ) {
        this.newCoord = newCoord;
        this.statToRollOn = statToRollOn;
        this.threshHold = threshHold;

    }

    @Override
    public void activate(Player currentPlayer) {
        //player.getstat * threshold ???????????????????????????????
        if(threshHold<currentPlayer.rollStat(statToRollOn)) {
            currentPlayer.setPos(newCoord);
        }
    }

    @Override
    public int getEventType() {
        return -3; //for xml parser
    }
}
