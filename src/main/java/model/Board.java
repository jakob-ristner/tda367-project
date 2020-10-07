package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    /*private Floor groundFloor;
    private Floor basementFloor;
    private Floor upperFloor;
     */

    private int eventPerFloor = 5;
    private List<Integer> indexList;
    Random rand = new Random();
    private final int numberOfFloors = 3;
    private List<Floor> floors = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    public void createBoard(){
        /*groundFloor = new Floor(generateEventList());
        basementFloor = new Floor(generateEventList());
        upperFloor = new Floor(generateEventList());
         */
        for (int i = 0; i < numberOfFloors ; i++) {
            floors.add(new Floor(generateEventList()));
        }

    }
    public void createEvents(int nItemEvents, int nRollDiceEvents, int nMoveEvents){
        for(int i =0; i<nItemEvents; i++) {
            events.add(EventFactory.createItemEvent());
        }
        for(int i =0; i<nRollDiceEvents; i++) {
            events.add(EventFactory.createRollDiceEvent());
        }
        for(int i =0; i<nMoveEvents; i++) {
            events.add(EventFactory.createMouseEvent());
        }


    }


    public Floor getFloor(int i){
        return floors.get(i);
    }


    private List<Integer> randomIndexList(){
        indexList = new ArrayList<>();
        for(int i = 0; i < events.size(); i++){

            indexList.add(i);
        }
        return indexList;
    }

    private List<Event> generateEventList(){
           int index;
           indexList = randomIndexList();
           List<Event> floorEventList = new ArrayList<>();
           for(int i = 0; i < eventPerFloor; i++){
               index = rand.nextInt(indexList.size());
               floorEventList.add(events.get(indexList.get(index)));
               indexList.remove(index);
           }
           return floorEventList;
    }

}
