package model.Events;

import controller.EventObserver;
import model.Event;

public abstract class GameEvent implements Event {
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
