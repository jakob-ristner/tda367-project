package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsanityHauntState implements GameState {
    Game game;
    public InsanityHauntState(){

    }


    @Override //Method for initing haunt, in this case, spawning the escape hatches
    public void init() {
        game = Game.getInstance(); //Not sure if this will work.
    }


    @Override
    public void turn(Player activePlayer) {
        if (activePlayer.isHaunted() && game.getPlayerTile(activePlayer).hasPlayer()){
            combat();
        }
        winConditionChecker();
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
