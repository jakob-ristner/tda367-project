package model;

import XMLParser.XMLParser;
import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EventFactory {



    private static Event createItemEvent(XMLParser parser, int index) {
        HashMap<Stat, Integer> statMap = new HashMap<>();
        statMap.put(Stat.SANITY,parser.getItemEventList().get(index).getSanity());
        statMap.put(Stat.STAMINA, parser.getItemEventList().get(index).getStamina());
        statMap.put(Stat.SPEED, parser.getItemEventList().get(index).getSpeed());
        statMap.put(Stat.STRENGTH, parser.getItemEventList().get(index).getStrength());
        Item item = new Item(parser.getItemEventList().get(index).getItemName(),statMap);

        String eventText = parser.getItemEventList().get(index).getEventText();

        ItemEvent event = new ItemEvent(item, eventText);
        return event;
    }
    private static Event createRollDiceEvent(XMLParser parser, int index) {
        String statToRollOn = parser.getRollEventList().get(index).getStat();
        int threshHold = parser.getRollEventList().get(index).getEventThreshold();
        int statChange = parser.getRollEventList().get(index).getStatChange();
        String eventText = parser.getRollEventList().get(index).getEventText();

        RollDiceEvent event = new RollDiceEvent(statToRollOn,threshHold, statChange, eventText);
        return event;
    }
    private static Event createMoveEvent(XMLParser parser, int index ){
        String stat =  parser.getMoveEventList().get(index).getStat();
        int treshHold = parser.getMoveEventList().get(index).getEventThreshold();
        String eventText = parser.getMoveEventList().get(index).getEventText();
        int deltaX =  parser.getMoveEventList().get(index).getDeltaX();
        int deltaY =  parser.getMoveEventList().get(index).getDeltaY();
        int deltaZ =  parser.getMoveEventList().get(index).getDeltaFloor();

        MoveEvent event = new MoveEvent(stat, treshHold, eventText, deltaX, deltaY, deltaZ);
        return event;
    }

    public static List<Event> createEventList(){
        XMLParser parser = new XMLParser();
        List<Event> eventList = new ArrayList<>();

        for(int i = 0; i < parser.getItemEventList().size(); i++){
            eventList.add(createItemEvent(parser, i));
        }

        for(int i = 0; i < parser.getMoveEventList().size(); i++){
            eventList.add(createMoveEvent(parser, i));
        }

        for(int i = 0; i < parser.getRollEventList().size(); i++){
            eventList.add(createRollDiceEvent(parser, i));
        }

        return eventList;
    }
}

