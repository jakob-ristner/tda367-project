package model;

import java.util.ArrayList;
import java.util.List;

public class EventFactory {
   private List<Event> events;


    public void createEvent(String eventType, int amountOfEvents) {
        List<Event> events = new ArrayList<>();
            for(int i = 0; i<amountOfEvents;i++) {
                if (eventType.equals("ItemEvent")) {
                    ItemEvent event = new ItemEvent();
                    events.add(event);
                }
                if (eventType.equals("RollDiceEvent")) {
                    RollDiceEvent event = new RollDiceEvent();
                    events.add(event);
                }
                if (eventType.equals("MoveEvent")) {
                    MoveEvent event = new MoveEvent();
                    events.add(event);
                }
            }

        }

    public List<Event> getEvents() {
        return events;
    }
}

