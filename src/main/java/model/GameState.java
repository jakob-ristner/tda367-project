package model;

import java.util.List;

/**
  *All states will (or game modes) will implement this interface.
  *Contains an init if game changes
  *Turn if the rules for the players changes
  *WinCondition if it changes

 */

public interface GameState {
     void init();
     void turn(Player activePlayer);
     boolean winConditionChecker();
     String getHauntText();
     String getButtonText();


}
