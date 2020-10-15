package model.Events;

import controller.EventObserver;
import model.Event;
import model.EventObservable;

public abstract class GameEvent implements EventObservable, Event {
    protected EventObserver observer;
    protected boolean permanent;

    GameEvent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }

    @Override
    public void setObserver(EventObserver observer){
        this.observer = observer;
    }
}
