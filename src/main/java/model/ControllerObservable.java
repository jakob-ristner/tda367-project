package model;

import controller.GameObserver;

import java.util.ArrayList;
import java.util.List;

public interface ControllerObservable {
    public void registerObserver(GameObserver observer);
    public void notifyNewTurn();
}
