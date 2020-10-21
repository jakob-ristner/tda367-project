package model;

import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Floor {
    private final int mapSize;
    private Tile[][] tiles;
    private final int amountOfStairs = 4;
    private final int stairSpacing;
    private Random rand = new Random();

    /**
     *
     * @param eventList List of events from Board
     * @param floor amount of floors.
     */

    Floor(List<Event> eventList, int floor) {
        mapSize = 6;
        stairSpacing  = mapSize/3;
        tiles = new Tile[mapSize][mapSize];
        generateTileMap();
        generateStairs(floor);
        addEventsRandom(eventList);
    }

    /**
     *
     * @param floor amount of floors
     * Method generates stairs, if floor 0 stair up, floor1 stair upDown, floor2 stair down
     */
    private void generateStairs(int floor) {
        if(floor == 0){
            setStairUp(0);
        }else if(floor == 1){
            setStairDown(0);
            setStairUp(mapSize-1);
        }else{
            setStairDown(mapSize-1);
        }
    }

    /**
     *
     * @param row
     * Set stair down, int is row, i+1 is Col
     */
    private void setStairUp(int row){
        Tile tile;
        for(int i = 0; i < amountOfStairs/2; i++){
            //tile = tiles[row][stairSpacing * (i+1)];
            tile = tiles[stairSpacing * (i+1)][row];
            tile.setStairUp(true);
        }

    }

    /**
     *
     * @param row
     * Set stair down, int is row, i+1 is Col
     */
    private void setStairDown(int row){
        Tile tile;
        for(int i = 0; i < amountOfStairs/2; i++){
            //tile = tiles[row][stairSpacing * (i+1)];
            tile = tiles[stairSpacing * (i+1)][row];
            tile.setStairDown(true);
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return tile on position x,y
     */
    Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    /**
     * adds event randomly and checks so that an event can only be places on empty tile
     * @param eventList
     */
    void addEventsRandom(List<Event> eventList) {
        int col;
        int row;
        for (int i = 0; i < eventList.size(); i++) {
            row = rand.nextInt(tiles.length);
            col = rand.nextInt(tiles[0].length);
            while (tiles[row][col].hasEvent() || tiles[row][col].hasStair()) {
                row = rand.nextInt(tiles.length);
                col = rand.nextInt(tiles[0].length);
            }
            tiles[row][col].setEvent(eventList.get(i));
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return returns hasmap of doors on tile on position x,y
     */
    HashMap<Integer, Boolean> getDoorsOnTile(int x, int y) {
        return tiles[x][y].getDoors();
    }

    /**
     * tries to activate event on tile on current player position
     * @param player current active player
     * @return true if an event was activated, false if not
     */
    boolean tryActivateEventOnTile(Player player) {
        Tile tile = tiles[player.getX()][player.getY()];
        return tile.tryActivateEvent();
    }

    /**
     * chains handleEvent method to tile
     * @param currentPlayer
     */
    void handleEvent(Player currentPlayer) {
        Tile tile = tiles[currentPlayer.getX()][currentPlayer.getY()];
        tile.handleEvent(currentPlayer);
    }


    private void generateTileMap() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(i, j, tiles);
            }
        }
    }

    /**
     * Chaining of a getter down to Event
     * @param currentPlayer current Active player
     * @return String of text to be displayed on mainGameView.
     */
    public String getEventEffectText(Player currentPlayer){
        Tile tile = tiles[currentPlayer.getX()][currentPlayer.getY()];
        return tile.getEventEffectText();
    }

    /**
     * Chaining of a getter down to Event
     * @param currentPlayer current Active player
     * @return String of text to be displayed on eventButton.
     */
    String getEventButtonText(Player currentPlayer){
        Tile tile = tiles[currentPlayer.getX()][currentPlayer.getY()];
        return tile.getEventButtonText();
    }

    List<Coord> stairsUp(int floor) {
        List<Coord> coords = new ArrayList<>();
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                if (tiles[x][y].hasStairUp()) {
                    coords.add(new Coord(x, y, floor));
                }
            }
        }
        return coords;
    }

    List<Coord> stairsDown(int floor) {
        List<Coord> coords = new ArrayList<>();
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                if (tiles[x][y].hasStairDown()) {
                    coords.add(new Coord(x, y, floor));
                }
            }
        }
        return coords;
    }

}
