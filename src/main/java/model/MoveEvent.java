package model;

import utilities.Coord;

public class MoveEvent implements Event {
    String statToRollOn; //TODO: Fix so that this isn't a string but instead is an Enum
    int threshHold;
    String eventText;

    int deltaX;
    int deltaY;
    int deltaZ;

    public MoveEvent(String statToRollOn, int threshHold, String eventText, int deltaX, int deltaY, int deltaZ) {
        this.statToRollOn = statToRollOn;
        this.threshHold = threshHold;
        this.eventText = eventText;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
    }

    @Override
    public void activate(Player currentPlayer) {
        //player.getstat * threshold ???????????????????????????????
      /*  if(threshHold > currentPlayer.rollStat(statToRollOn)) { TODO:Please fix this method later guys. :)
            currentPlayer.addCoord(coordDelta);
        }*/
        System.out.println("move event triggered");
    }

    @Override
    public int getEventType() {
        return -3; //for xml parser
    }
}
