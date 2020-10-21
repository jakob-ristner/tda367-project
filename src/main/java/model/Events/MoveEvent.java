package model.Events;

import model.Player;
import model.Stat;
import utilities.Coord;

public class MoveEvent extends GameEvent {
    Stat statToRollOn;
    int threshHold;

    String eventText;
    int eventType;
    private String effectText;
    private String eventButtonText;
    private boolean positiveEvent;


    Coord coord;


    public MoveEvent(int statToRollOn, int threshHold,
                     String eventText, int deltaX, int deltaY, int deltaZ,
                     int eventType, boolean permanent, boolean positiveEvent) {
        super(permanent);
        this.statToRollOn = Stat.from(statToRollOn);
        this.threshHold = threshHold;
        this.eventText = eventText;
        coord = new Coord(deltaX,deltaY,deltaZ);
        this.eventType = eventType;
        this.positiveEvent = positiveEvent;
    }

    /**
     * Activates the event. Sets the buttonText to be displayed and tells the controller to update the view.
     */
    @Override
    public void activate() {
        eventButtonText = "Roll " + statToRollOn.toString().toLowerCase() + " higher than " + threshHold;
        String eventTextEnding = " to avoid being moved!";
        if (positiveEvent)
            eventTextEnding = " to move!";
        eventButtonText = eventButtonText + eventTextEnding;
        observer.updateEventView(eventType, eventText);
    }

    /**
     * Sets effectText and handles the event via rolling a player's stat.
     * asks the controller to update the view.
     * @param currentPlayer
     */
    @Override
    public void handleEvent(Player currentPlayer) {
        int playerDiceRoll = currentPlayer.rollStat(statToRollOn);
        boolean playerRolledHigher = playerDiceRoll > threshHold;
        boolean moved = playerRolledHigher == positiveEvent;
        effectText = "You are still standing on the same tile";
        if (moved) {
            effectText = "you were moved";
            currentPlayer.addCoord(coord);
        }
        observer.updateEventEffect();

        /*
        if(threshHold > currentPlayer.rollStat(statToRollOn)) {//TODO: Fix so that we have 2 scenarios coming from the xml parser. One negative and one positive.
            effectText = "You were moved";
            observer.updateEventEffect();
            currentPlayer.addCoord(coord);
        }else{
         effectText = "You're still standing on the same tile";
         observer.updateEventEffect();
        }
        System.out.println("move event triggered");

         */
    }

    @Override
    public int getEventType() {
        return eventType; //From XMLparser
    }

    @Override
    public String getEventEffectText() {
        return effectText;
    }

    @Override
    public String getEventButtonText() {
        return eventButtonText;
    }
}
