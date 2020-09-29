package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Floor groundFloor;
    private Floor basementFloor;
    private Floor upperFloor;
    private List<Event> eventList = new ArrayList<>();
    private int eventPerFloor = 5;
    private List<Integer> indexList = new ArrayList<>();
    Random rand = new Random();

    public void createBoard(){
        groundFloor = new Floor(generateEventList());
        basementFloor = new Floor(generateEventList());
        upperFloor = new Floor(generateEventList());

    }

    private void randomIndexList(){
        for(int i = 0; i < eventList.size(); i++){
            indexList.add(i);
        }
    }

    private List<Event> generateEventList(){
           int index;
           List<Event> floorEventList = new ArrayList<>();
           for(int i = 0; i < eventPerFloor; i++){
               index = rand.nextInt(indexList.size());
               floorEventList.add(eventList.get(indexList.get(index)));
               indexList.remove(index);
           }
           return floorEventList;
    }

    private void getEventList(){

    }
}
