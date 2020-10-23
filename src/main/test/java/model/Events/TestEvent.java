package model.Events;


import model.EventObserver;
import model.Item;
import model.Player;

/**
 * In order to mimic the model structure this package was created. Otherwise we can't create or handle events
 * Need a dummyObserver or else nullPointer
 * In this class events are created and handled, called on from TestEventHelper.
 * Set threshHold to 500 so that all rolls fail.
 */

public class TestEvent {
    final int threshHold = 500;
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

    public void testItemEvent(Player player, Item item) {
        gameEvent.setObserver(dummyObserver);
        ItemEvent itemEvent = new ItemEvent(item, "Testin123", 3);
        itemEvent.handleEvent(player);
    }

    public void testMoveEventNegative(Player player) {
        gameEvent.setObserver(dummyObserver);
        MoveEvent moveEvent = new MoveEvent(0, threshHold, "Test123",
                -1, 0, 1, -2, true, false);
        moveEvent.handleEvent(player);
    }

    public void testMoveEventPositive(Player player) {
        gameEvent.setObserver(dummyObserver);
        MoveEvent moveEvent = new MoveEvent(0, threshHold, "Test123",
                1, 0, 1, -2, true, true);
        moveEvent.handleEvent(player);
    }

    public void testRollDiceEventNegative(Player player, int statChange, int statToRollOn) {
        gameEvent.setObserver(dummyObserver);
        RollDiceEvent rollDiceEvent = new RollDiceEvent(statToRollOn, threshHold, statChange,
                "Testing123", -1, true);
        rollDiceEvent.handleEvent(player);
    }

    public void testRollDiceEventPositive(Player player, int statChange, int statToRollOn) {
        gameEvent.setObserver(dummyObserver);
        RollDiceEvent rollDiceEvent = new RollDiceEvent(statToRollOn, threshHold, statChange,
                "Testing123", -1, true);
        rollDiceEvent.handleEvent(player);
    }

    class DummyObserver implements EventObserver {

        @Override
        public void updateEventView(int eventType, String eventText) {

        }

        @Override
        public void updateEventEffect() {

        }

    }

}
