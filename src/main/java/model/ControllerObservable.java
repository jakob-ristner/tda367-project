package model;

import controller.GameObserver;

import java.util.ArrayList;
import java.util.List;

public interface ControllerObservable {
    public void setObserver(GameObserver observer);
    public void notifyNewTurn(); // might be unecessary
    public void notifyGameEvent();
    public void notifyGameStart();
}
