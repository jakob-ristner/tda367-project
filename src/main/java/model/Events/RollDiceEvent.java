package model.Events;

import model.Player;
import model.Stat;

import java.util.HashMap;

public class RollDiceEvent extends GameEvent {
    Stat statToRollOn;
    int numberToRollVersus;
    private String eventText;
    private int eventType;
    private String effectText;
    private String eventButtonText;

    int loseStatChange;

    public RollDiceEvent(int statToRollOn, int numberToRollVersus, int loseStatChange, String eventText, int eventType, boolean permanent) {
        super(permanent);
        this.statToRollOn = Stat.from(statToRollOn);
        this.numberToRollVersus = numberToRollVersus;
        this.loseStatChange = loseStatChange;
        this.eventText = eventText;
        this.eventType = eventType;
        System.out.println(this.statToRollOn);
        System.out.println(eventText);
    }


    /**
     * Activates the Event.
     * Sets the buttonText.
     * Asks the controller to update the view.
     */
    @Override
    public void activate() {
        eventButtonText = "Roll " + statToRollOn.toString().toLowerCase() + " higher than " + numberToRollVersus + " to succeed!";
        observer.updateEventView(eventType, eventText);
        System.out.println("rollDiceEvent");
    }

    /**
     * Handles the event via rolling a player's stat.
     * Sets effectText.
     * Asks controller to update view.
     * @param currentPlayer
     */
    @Override
    public void handleEvent(Player currentPlayer) {
        HashMap<Stat,Integer> statsToUpdate = new HashMap<>();

        statsToUpdate.put(statToRollOn, loseStatChange);
        int diceRoll = currentPlayer.rollStat(statToRollOn);
        if(numberToRollVersus > diceRoll){ //TODO: Skaffa texten från xml.
            effectText = "You rolled " + diceRoll + " which is lower than " + numberToRollVersus;
            currentPlayer.getCharacter().updateStat(statsToUpdate); //Why is the stats only updated if you lose the roll?
                                                                    //sometimes something good can happen if you succeed right?
        }else{
            effectText = "You rolled higher";
        }
        observer.updateEventEffect();
        System.out.println("rolldice event triggered");
    }



    @Override
    public int getEventType() {
        return eventType;
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
