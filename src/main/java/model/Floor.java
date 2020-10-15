package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Floor {
    private EventFactory eventFactory;
    private Tile[][] tiles = new Tile[6][6];
    private List<Tile> roomList = new ArrayList<>();
    private Random rand = new Random();

    Floor(List<Event> eventList) {
        generateTileMap();
        addEventsRandom(eventList);
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
            while (tiles[row][col].hasEvent()) {
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

}
