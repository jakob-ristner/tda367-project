package controller;

/**
 * Observer pattern between Game and Controller
 */
public interface GameObserver {
    void updateCurrentPlayer();
    void updateMapData();
    void initMapData();
    void updateTurn();
    void initHauntView();
    void initCombatScreen();
    void initGameOverView();


}
