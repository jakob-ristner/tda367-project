package model;

import java.util.HashMap;

public class RollDiceEvent implements Event {
    Stat statToRollOn; //TODO: Fix so based on enum
    int numberToRollVersus;
    private String eventText;

    int loseStatChange;

    public RollDiceEvent(int statToRollOn, int numberToRollVersus, int loseStatChange, String eventText) {
        this.statToRollOn = Stat.from(statToRollOn);
        this.numberToRollVersus = numberToRollVersus;
        this.loseStatChange = loseStatChange;
        this.eventText = eventText;
        System.out.println(this.statToRollOn);
        System.out.println(eventText);
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
