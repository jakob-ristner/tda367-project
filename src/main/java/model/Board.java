package model;

import controller.EventObserver;
import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Board {

    private List<Integer> indexList;
    private List<Event> events;
    private final Random rand = new Random();
    private final List<Floor> floors;
    private final int numberOfFloors = 3;
    private final int eventPerFloor = 3;

    public Board(){
        floors = new ArrayList<>();
        events = EventFactory.createEventList();

        for (int i = 0; i < numberOfFloors ; i++) {
            floors.add(new Floor(generateEventList()));
        }

    }

    List<Event> getEvents(){
        return events;
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

    public void handleEvent(Player currentPlayer) {
        Floor floor = floors.get(currentPlayer.getFloor());
        floor.handleEvent(currentPlayer);
    }

    public String getEventEffectText(Player currentPlayer){
        Floor floor = floors.get(currentPlayer.getFloor());
        return floor.getEventEffectText(currentPlayer);
    }
}
