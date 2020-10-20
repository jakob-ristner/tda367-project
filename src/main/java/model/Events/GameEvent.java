package model.Events;

import controller.EventObserver;
import model.Event;

/**
 * Abstraction of all events.
 * Some Events are permanent, stairs to another floor or a hole in the ground four example.
 *
 */

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
