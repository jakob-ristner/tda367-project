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
    private boolean positiveEvent;
    private int statChange;

    /**
     *
     * @param statToRollOn which stat to roll on, using int as an identifier for stat
     * @param numberToRollVersus the value you have to roll versus
     * @param statChange the stat outcome after an event
     * @param eventText for player interaction, text involving the event
     * @param eventType In order to know which view to use
     * @param permanent checks if the event is permanent
     */
    public RollDiceEvent(int statToRollOn, int numberToRollVersus, int statChange, String eventText, int eventType, boolean permanent) {
        super(permanent);
        this.statToRollOn = Stat.from(statToRollOn);
        this.numberToRollVersus = numberToRollVersus;
        this.statChange = statChange;
        this.eventText = eventText;
        this.eventType = eventType;
        System.out.println(this.statToRollOn);
        System.out.println(eventText);
        this.positiveEvent = Math.signum(statChange) == 1;
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
    }

    /**
     * Handles the event via rolling a player's stat.
     * RollDiceEvent can both be positive and negative, hence the if statements.
     * Sets effectText.
     * Asks controller to update view.
     * @param currentPlayer
     */
    @Override
    public void handleEvent(Player currentPlayer) {
        HashMap<Stat,Integer> statsToUpdate = new HashMap<>();

        statsToUpdate.put(statToRollOn, statChange);
        int diceRoll = currentPlayer.rollStat(statToRollOn);

        if(numberToRollVersus > diceRoll){
            effectText = "You rolled " + diceRoll + " which is lower than " + numberToRollVersus;
            if(!positiveEvent){
                currentPlayer.getCharacter().updateStat(statsToUpdate);
            }
        }else{
            if(positiveEvent){
                currentPlayer.getCharacter().updateStat(statsToUpdate);
            }
            effectText = "You succeeded in the roll by rolling" + " " + diceRoll;
        }
        observer.updateEventEffect();
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
