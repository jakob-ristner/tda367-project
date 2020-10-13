package model;

import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Board {
    /*private Floor groundFloor;
    private Floor basementFloor;
    private Floor upperFloor;
     */

    private int eventPerFloor;
    private List<Integer> indexList;
    private final int numberOfFloors;
    private List<Floor> floors;
    private List<Event> events;
    private Random rand = new Random();

    public Board(){
        /*groundFloor = new Floor(generateEventList());
        basementFloor = new Floor(generateEventList());
        upperFloor = new Floor(generateEventList());
         */
        numberOfFloors = 3;
        floors = new ArrayList<>();
        createEvents(3, 5, 6);
        for (int i = 0; i < numberOfFloors ; i++) {
            floors.add(new Floor(generateEventList()));
        }

    }
    public void createEvents(int nItemEvents, int nRollDiceEvents, int nMoveEvents){
        HashMap<Stat,Integer> itemStats = new HashMap<>();
        itemStats.put(Stat.STRENGTH,2);
        events = new ArrayList<>();

        for(int i =0; i<nItemEvents; i++) {
            events.add(EventFactory.createItemEvent(new Item("Sword",itemStats)));
        }
        for(int i =0; i<nRollDiceEvents; i++) {
            events.add(EventFactory.createRollDiceEvent(Stat.STRENGTH,1,2));
        }
        for(int i =0; i<nMoveEvents; i++) {
            events.add(EventFactory.createMouseEvent(new Coord(1,2,3),Stat.STRENGTH,5));
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

    HashMap<Integer, Boolean> getCurrentPlayerTileDoors(Coord coord) {
        Floor currentFloor = floors.get(coord.getFloor());
        return currentFloor.getDoorsOnTile(coord.getX(), coord.getY());
    }

    boolean tryActivateEventOnPlayerPos(Player player) {
        Floor floor = floors.get(player.getFloor());
        return floor.tryActivateEventOnTile(player);
    }
}
