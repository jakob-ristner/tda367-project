package model;
import model.Events.MoveEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFloor {

    /**
     * Adding 15 events to list
     * Create a floor with the events.
     * Check if 15 event is on the floor
     * Sometimes it does not cover if statement in addTile, but should work.
     */

    @Test
    public void testAddTile(){
        int numberOfEvents = 15;
        List<Event> events = new ArrayList<>();

        for(int i = 0; i < numberOfEvents; i++){
            Event event = new MoveEvent(1,1,"h",1,2,3,1,true,true);
            events.add(event);
        }

        Floor floor = new Floor(events, 1);
        int count = 0;
        for(int x = 0; x<6; x++){
            for (int y = 0; y<6; y++){
                if(floor.getTile(x,y).hasEvent()){
                    count++;
                }
            }
        }
        Assert.assertEquals(count,numberOfEvents);

    }

}
