package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {
    private List<Tile> roomList = new ArrayList<>();
    private Random rand = new Random();

    public Floor(List<Event> eventList){
        generateTileList();
        List<Integer> randomIndexList;
        randomIndexList = randomizeIndex(eventList.size());
        for(int i = 0; i < eventList.size(); i++){
            roomList.get(randomIndexList.get(i)).setEvent(eventList.get(i));
        }
    }

    public void generateStairs(){
    }


    private List<Integer> randomizeIndex(int numEvent){
        List<Integer> indexList = new ArrayList<>();
        int index;
        for(int i = 0; i< 36; i++){
            indexList.add(i);
        }

        List<Integer> randomIndexList = new ArrayList<>();
        for(int i = 0; i < numEvent; i++){
            index = rand.nextInt(indexList.size());
            randomIndexList.add(indexList.get(index));
            indexList.remove(index);
        }

        return randomIndexList;
    }

    private void generateTileList(){
        for(int i = 0; i < 36; i++){
            roomList.add(new Tile());
        }
    }




}
