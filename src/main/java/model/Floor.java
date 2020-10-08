package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {
    private EventFactory eventFactory;
    private Tile[][] tiles= new Tile[6][6];
    private List<Tile> roomList = new ArrayList<>();
    private Random rand = new Random();

    public Floor(List<Event> eventList){
        generateTileMap();
        addEventsRandom(eventList);
        /*
        List<Integer> randomIndexList;
        randomIndexList = randomizeIndex(eventList.size());
        for(int i = 0; i < eventList.size(); i++){
            roomList.get(randomIndexList.get(i)).setEvent(eventList.get(i));
        }
         */
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public void generateStairs(){
    }


   public void addEventsRandom(List<Event> eventList){
        int col;
        int row;
       for (int i = 0; i < eventList.size() ; i++) {
           row = rand.nextInt(tiles.length);
           col = rand.nextInt(tiles[0].length);
           while (tiles[row][col].hasEvent()){
               row = rand.nextInt(tiles.length);
               col = rand.nextInt(tiles[0].length);
           }
           tiles[row][col].setEvent(eventList.get(i));
       }
   }
/*
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

 */

    private void generateTileMap(){
        for (int i = 0; i < tiles.length; i++){
            for (int j = 0; j < tiles[i].length; j++){
                tiles[i][j] = new Tile(i,j, tiles);
            }
        }
    }

}
