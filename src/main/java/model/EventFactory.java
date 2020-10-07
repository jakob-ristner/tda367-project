package model;

import java.util.ArrayList;
import java.util.List;

public class EventFactory {

    public static Event createItemEvent() {
        ItemEvent event = new ItemEvent();
        return event;
    }
    public static Event createRollDiceEvent() {
        RollDiceEvent event = new RollDiceEvent();
        return event;
    }
    public static Event createMouseEvent(){
        MoveEvent event = new MoveEvent();
        return event;
    }
}

