package model.Events;


import model.*;
import model.Events.GameEvent;
import model.Events.ItemEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestEvent {
    class DummyObserver implements EventObserver {

        @Override
        public void updateEventView(int eventType, String eventText) {

        }

        @Override
        public void updateEventEffect() {

        }

    }
    GameEvent gameEvent = new GameEvent(true) {
        @Override
        public void activate() {

        }

        @Override
        public void handleEvent(Player currentPlayer) {

        }

        @Override
        public int getEventType() {
            return 0;
        }

        @Override
        public String getEventEffectText() {
            return null;
        }

        @Override
        public String getEventButtonText() {
            return null;
        }
    };
    DummyObserver dummyObserver = new DummyObserver();


    public void testItemEvent(Player player,Item item){

        gameEvent.setObserver(dummyObserver);
        ItemEvent itemEvent = new ItemEvent(item,"Testin123",3);
        itemEvent.handleEvent(player);

    }
    public void testMoveEventNegative(Player player){
        gameEvent.setObserver(dummyObserver);
        MoveEvent moveEvent = new MoveEvent(0,500,"Test123",
                -1,0,1,-2,true,false);
        moveEvent.handleEvent(player);
    }
    public void testMoveEventPositive(Player player){
        gameEvent.setObserver(dummyObserver);
        MoveEvent moveEvent = new MoveEvent(0,500,"Test123",
                1,0,1,-2,true,true);
        moveEvent.handleEvent(player);
    }

}
