package model;


import model.Events.ItemEvent;
import model.Events.TestEvent;
import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

import java.util.HashMap;

public class testHelper {
    TestEvent testEvent = new TestEvent();


    @Test
    public void testItemEvent(){
        Player testPlayer = new Player();
        testPlayer.setCharacter(KharacterFactory.createRufus());
        int statStart= testPlayer.getCharacter().getStat(Stat.STRENGTH);
        HashMap<Stat,Integer> stats = new HashMap<>();
        stats.put(Stat.STRENGTH,1);
        Item item = new Item("Swort",stats);
        testEvent.testItemEvent(testPlayer,item);
        Assert.assertEquals(statStart+item.getStat(Stat.STRENGTH),testPlayer.getCharacter().getStat(Stat.STRENGTH));

    }
    @Test
    public void testMoveEvent(){
        Player testPlayer = new Player();
        testPlayer.setCharacter(KharacterFactory.createRufus());
        testPlayer.setPos(new Coord(1,2,2));
        int startX = testPlayer.getX();

        testEvent.testMoveEventNegative(testPlayer);
        int currX = testPlayer.getX();
        Assert.assertEquals(currX,startX-1);

        testEvent.testMoveEventPositive(testPlayer);
        Assert.assertEquals(currX,testPlayer.getX());

    }
    @Test

    public void testRollDiceEvent(){
        Player testPlayer = new Player();
        testPlayer.setCharacter(KharacterFactory.createRufus());
        int statChange1 = -5;
        int startStamina = testPlayer.getCharacter().getStat(Stat.from(3));

        testEvent.testRollDiceEventNegative(testPlayer,statChange1,3);
        Assert.assertEquals(startStamina+statChange1,testPlayer.getCharacter().getStat(Stat.STAMINA));

        int statChange2 = 2;
        testEvent.testRollDiceEventPositive(testPlayer,statChange2,3);
        Assert.assertEquals(startStamina+statChange1,testPlayer.getCharacter().getStat(Stat.STAMINA));



    }

}
