package model;

import controller.GameObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * ObserverPattern between Controller and Game
 */
public interface ControllerObservable {
     void setObserver(GameObserver observer);
     void notifyNewTurn(); // might be unecessary
     void notifyGameData();
     void notifyGameStart();
     void notifyHaunt();
     void notifyCombat();
}
