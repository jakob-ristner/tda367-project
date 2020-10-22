package model.Events;

import model.EventObserver;
import model.Event;

/**
 * Abstraction of all events.
 * Some Events are permanent, stairs to another floor or a hole in the ground four example.
 * In order to know which view to use
 */

public abstract class GameEvent implements Event {
    protected static EventObserver observer;    //Bad code practise. Should not be static. Didn't know how to fix without though.
    protected boolean permanent;

    GameEvent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }

    @Override
    public void setObserver(EventObserver observer) {
        GameEvent.observer = observer;
    }
}
