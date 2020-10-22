package model;

/**
 * All states will (or game modes) will implement this interface.
 * Contains an init if the game changes
 * Turn if the rules for the players changes
 * WinCondition if the win condition changes.
 */

public interface GameState {
    void init();

    void turn(Player activePlayer);

    boolean winConditionChecker();

    String getHauntText();


}
