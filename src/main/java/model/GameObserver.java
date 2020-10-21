package model;

/**
 * Observer pattern between Game and Controller
 */
public interface GameObserver {
    void updateCurrentPlayer();
    void updateMapData();
    void initMapData();
    void initHauntView();
    void initCombatScreen();
    void initGameOverView();


}
