package model.Events;

import controller.EventObserver;
import model.Event;

public abstract class GameEvent implements Event {
    protected EventObserver observer;

    GameEvent() {
    }

    @Override
    public void setObserver(EventObserver observer){
        this.observer = observer;
    }
}
