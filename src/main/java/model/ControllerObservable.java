package model;

import controller.GameObserver;

import java.util.ArrayList;
import java.util.List;

public interface ControllerObservable {
     void setObserver(GameObserver observer);
     void notifyNewTurn(); // might be unecessary
     void notifyGameData();
     void notifyGameStart();
     void notifyHaunt();
}
