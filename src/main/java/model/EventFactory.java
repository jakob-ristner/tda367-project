package model;

import utilities.Coord;



public class EventFactory {

    public static Event createItemEvent(Item item) {
        ItemEvent event = new ItemEvent(item);
        return event;
    }
    public static Event createRollDiceEvent(Stat statToRollOn, int threshHold, int loseStatChange  ) {
        RollDiceEvent event = new RollDiceEvent(statToRollOn,threshHold,loseStatChange);
        return event;
    }
    public static Event createMouseEvent(Coord coord, Stat statToRollOn, int threshHold ){
        MoveEvent event = new MoveEvent(coord, statToRollOn, threshHold);
        return event;
    }
}

