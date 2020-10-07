package controller;

public interface GameObserver {
    void updateCurrentPlayer();
    void updateMapData();
    void initMapData();
    void updateTurn();
}
