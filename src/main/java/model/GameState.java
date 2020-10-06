package model;

import java.util.List;

public interface GameState {
     void init();
     void turn(Player activePlayer);
     void winConditionChecker();


}
