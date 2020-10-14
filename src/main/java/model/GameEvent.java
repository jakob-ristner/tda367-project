package model;

import controller.EventObserver;

public abstract class GameEvent implements EventObservable, Event {
    protected EventObserver observer;

    public GameEvent() {
    }

    @Override
    public void setObserver(EventObserver observer){
        this.observer = observer;

    }
}
