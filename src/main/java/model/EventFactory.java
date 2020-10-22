package model;

import XMLParser.XMLParser;
import model.Events.GameWonEvent;
import model.Events.ItemEvent;
import model.Events.MoveEvent;
import model.Events.RollDiceEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Factory for creation of events.
 */
public abstract class EventFactory {

    /**
     * generates list of events from xml file
     *
     * @return event list
     */
    static List<Event> createEventList() {
        XMLParser parser = new XMLParser();
        List<Event> eventList = new ArrayList<>();

        for (int i = 0; i < parser.getItemEventList().size(); i++) {
            eventList.add(createItemEvent(parser, i));
        }

        for (int i = 0; i < parser.getMoveEventList().size(); i++) {
            eventList.add(createMoveEvent(parser, i));
        }

        for (int i = 0; i < parser.getRollEventList().size(); i++) {
            eventList.add(createRollDiceEvent(parser, i));
        }

        return eventList;
    }

    /**
     * @return returns events that triggers the "GameWonEventView"
     */
    static Event createEscapeEvent() {
        GameWonEvent event = new GameWonEvent();
        return event;
    }

    private static Event createItemEvent(XMLParser parser, int index) {
        HashMap<Stat, Integer> statMap = new HashMap<>();
        statMap.put(Stat.SANITY, parser.getItemEventList().get(index).getSanity());
        statMap.put(Stat.STAMINA, parser.getItemEventList().get(index).getStamina());
        statMap.put(Stat.SPEED, parser.getItemEventList().get(index).getSpeed());
        statMap.put(Stat.STRENGTH, parser.getItemEventList().get(index).getStrength());
        Item item = new Item(parser.getItemEventList().get(index).getItemName(), statMap);

        String eventText = parser.getItemEventList().get(index).getEventText();
        int eventType = parser.getItemEventList().get(index).getEventType();

        ItemEvent event = new ItemEvent(item, eventText, eventType);
        return event;
    }

    private static Event createRollDiceEvent(XMLParser parser, int index) {
        int statToRollOn = parser.getRollEventList().get(index).getStat();
        int threshHold = parser.getRollEventList().get(index).getEventThreshold();
        int statChange = parser.getRollEventList().get(index).getStatChange();
        String eventText = parser.getRollEventList().get(index).getEventText();
        int eventType = parser.getRollEventList().get(index).getEventType();

        RollDiceEvent event = new RollDiceEvent(statToRollOn, threshHold, statChange, eventText, eventType, false);
        return event;
    }

    private static Event createMoveEvent(XMLParser parser, int index) {
        int stat = parser.getMoveEventList().get(index).getStat();
        int threshold = parser.getMoveEventList().get(index).getEventThreshold();

        String eventText = parser.getMoveEventList().get(index).getEventText();
        int eventType = parser.getMoveEventList().get(index).getEventType();

        int deltaX = parser.getMoveEventList().get(index).getDeltaX();
        int deltaY = parser.getMoveEventList().get(index).getDeltaY();
        int deltaZ = parser.getMoveEventList().get(index).getDeltaFloor();
        boolean positiveEvent = parser.getMoveEventList().get(index).getPositiveEvent();


        MoveEvent event = new MoveEvent(stat, threshold, eventText,
                deltaX, deltaY, deltaZ, eventType,
                true, positiveEvent);
        return event;
    }

}

