package model;

import java.util.List;

public interface GameState {
     void init(Game game, List<Player> playerList,Player activePlayer);
     void turn(Player activePlayer);


}
