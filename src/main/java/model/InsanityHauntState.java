package model;

import java.util.List;

public class InsanityHauntState implements GameState {
    @Override
    public void init(Game game, List<Player> playerList, Player activePlayer) {
    }

    @Override
    public void turn(Player activePlayer,Game game) {
        if (activePlayer.isHaunted() && game.getPlayerTile(activePlayer).hasPlayer()){

            //combat()
        }

        //WinConditionChecker();

    }

    public int combat(Player activePlayer, Player insanePlayer){
        int attacker = activePlayer.rollStat(Stat.STRENGTH);
        int defender = insanePlayer.rollStat(Stat.STRENGTH);
        int result = defender-attacker;
        if(result <= 0){
            return 0;
        }
        return result;
    }
    //updateStatsBasedOnCombat

    public 


    @Override
    public void winConditionChecker() {
        
    }
}
