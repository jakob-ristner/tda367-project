package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsanityHauntState implements GameState {
    Game game;
    int numEscapeHatch = 4;
    Random rand = new Random();

    public InsanityHauntState(){

    }


    @Override //Method for initing haunt, in this case, spawning the escape hatches
    public void init() {
        game = Game.getInstance(); //Not sure if this will work.
        createEscapeHatches();
    }


    @Override
    public void turn(Player activePlayer) {
        if (activePlayer.isHaunted() && game.getPlayerTile(activePlayer).hasPlayer()){
            combat();
        }
        winConditionChecker();
    }


    private void createEscapeHatches(){
        Tile tile;
        int i = 0;
        while(i < numEscapeHatch) {
            tile = game.getBoard().getFloor(1).getTile(rand.nextInt(6), rand.nextInt(6));
            if (!tile.hasEvent()) {
                tile.setEvent(new ItemEvent()); //Change so that EventFactory has a factory for hauntEvents
                i++;
            }
        }
    }

    public void combat(){
        for (Player p: createListOfPlayersInSameRoom()){
            int insanePlayerStrenght = game.getCurrentPlayer().rollStat(Stat.STRENGTH);
            int playerInRoomStrenght = p.rollStat(Stat.STRENGTH);
            int damage = insanePlayerStrenght-playerInRoomStrenght;
            p.getCharacter().updateStatFromCombat(Stat.STAMINA,damage);
        }
    }

    public List<Player> createListOfPlayersInSameRoom() {
        List<Player> listOfPlayersInTheSameRoom = new ArrayList<>();
        for (Player p: game.getPlayerList()) {
            if (game.getCurrentPlayer().getX() == p.getX() && game.getCurrentPlayer().getY() == p.getY()) {
                listOfPlayersInTheSameRoom.add(p);
            }
        }
        return listOfPlayersInTheSameRoom;
    }

    @Override
    public void winConditionChecker() {
        if(game.getPlayerList().isEmpty()){
            System.out.println("Monster Won");
        }

    }
}
