package model.Events;

import controller.EventObserver;
import model.Event;
import model.EventObservable;

public abstract class GameEvent implements EventObservable, Event {
    protected EventObserver observer;

    GameEvent() {
    }

    @Override
    public void setObserver(EventObserver observer){
        this.observer = observer;
    }
}
