package model;
import model.Events.MoveEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testFloor {

    /**
     * Created a 6*6 matrix, while loop in order to fill an eventlist with 36 events.
     * Create a floor with the events.
     * Check if each floor has an event, also control that the whole method has been covered since the events are put in
     * a random place.
     */

    @Test
    public void testAddTile(){
        int numberOfTiles = 6*6;
        List<Event> events = new ArrayList<>();
        while (0<numberOfTiles){
            Event event = new MoveEvent(1,1,"h",1,2,3,1,true);
            events.add(event);
            numberOfTiles--;
        }
        Floor floor = new Floor(events, 1);
        for(int x = 0; x<6; x++){
            for (int y = 0; y<6; y++){
                Assert.assertTrue(floor.getTile(x,y).hasEvent());

            }
        }



    }

}
