package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsanityHauntState implements GameState {
    Game game;
    public InsanityHauntState(Game game){
        this.game = game.getGame();
    }

    @Override //Method for initing haunt, in this case, spawning the escape hatches
    public void init() {
    }


    @Override
    public void turn(Player activePlayer,Game game) {
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
