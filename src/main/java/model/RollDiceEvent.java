package model;

import java.util.HashMap;

public class RollDiceEvent implements Event {
    Stat statToRollOn;
    int numberToRollVersus;

    int loseStatChange;

    public RollDiceEvent(Stat statToRollOn, int numberToRollVersus, int loseStatChange) {
        this.statToRollOn = statToRollOn;
        this.numberToRollVersus = numberToRollVersus;
        this.loseStatChange = loseStatChange;
    }

    @Override
    public void activate(Player currentPlayer) {
        HashMap<Stat,Integer> statsToUpdate = new HashMap<>();
        statsToUpdate.put(statToRollOn, loseStatChange);
        int diceRoll = currentPlayer.rollStat(statToRollOn);
        if(numberToRollVersus > diceRoll){
            currentPlayer.getCharacter().updateStat(statsToUpdate);
        }
        System.out.println("rolldice event triggered");
    }

    @Override
    public int getEventType() {
        return -2;
    }
}
