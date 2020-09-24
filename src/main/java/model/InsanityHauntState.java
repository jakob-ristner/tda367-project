package model;

import java.util.List;

public class InsanityHauntState implements GameState {
    @Override
    public void init(Game game, List<Player> playerList, Player activePlayer) {

    }

    @Override
    public void turn(Player activePlayer,Game game) {
        if (game.roomContainsInsanePlayer()){
            //combat()
        }

        //WinConditionChecker();

    }

    @Override
    public void winConditionChecker() {
        
    }
}
