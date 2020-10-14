package model;

import java.util.HashMap;

public class RollDiceEvent extends GameEvent {
    Stat statToRollOn;
    int numberToRollVersus;
    private String eventText;
    private int eventType;

    int loseStatChange;

    public RollDiceEvent(int statToRollOn, int numberToRollVersus, int loseStatChange, String eventText, int eventType) {
        this.statToRollOn = Stat.from(statToRollOn);
        this.numberToRollVersus = numberToRollVersus;
        this.loseStatChange = loseStatChange;
        this.eventText = eventText;
        this.eventType = eventType;
        System.out.println(this.statToRollOn);
        System.out.println(eventText);
    }

    @Override
    public void activate(Player currentPlayer) {
        /*HashMap<Stat,Integer> statsToUpdate = new HashMap<>();

        statsToUpdate.put(statToRollOn, loseStatChange);
        int diceRoll = currentPlayer.rollStat(statToRollOn);
        if(numberToRollVersus > diceRoll){
            currentPlayer.getCharacter().updateStat(statsToUpdate);
        }
        System.out.println("rolldice event triggered"); */
        observer.updateEventView(eventType, eventText);
        System.out.println("rollDiceEvent");
    }

    @Override
    public int getEventType() {
        return eventType;
    }

}
