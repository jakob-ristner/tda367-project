package model;

import javafx.scene.control.Spinner;
import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

import java.util.HashMap;

/**
 * Testing Player methods.
 */
public class TestPlayer {

    /**
     *Testing equipping an item.
     * Check
     */
    @Test
    public void testEquippingItem(){
        Player player = new Player();

        Kharacter medera = KharacterFactory.createMedera();
        player.setCharacter(medera);
        int characterStat = player.getCharacter().getStat(Stat.STRENGTH);

        HashMap<Stat, Integer> swordStats = new HashMap<>();
        swordStats.put(Stat.STRENGTH,2);
        Item sword = new Item("Sword", swordStats);

        player.addToInventory(sword);
        Assert.assertEquals(characterStat+sword.getStat(Stat.STRENGTH),player.getCharacter().getStat(Stat.STRENGTH));


    }

    /**
     * Test rolling a dice between the minRoll=0 and maxRoll = statValue
     */

    @Test
    public void testRollDice(){

        Player player = new Player();
        Kharacter medera = KharacterFactory.createMedera();
        player.setCharacter(medera);
        int maxRoll =  player.getCharacter().getStat(Stat.SPEED);
        int minRoll = 0;
        int rollValue = player.rollStat(Stat.SPEED);

        Assert.assertTrue(minRoll <= rollValue && rollValue <= maxRoll);
    }

    /**
     * First testing playerPos by setting a pos and then move the player in all directions (x,y,floor).
     * Also test moving the character in a 2d pane.
     */

    @Test
    public void testMovePlayer(){
        Player player = new Player();
        player.setPos(new Coord(1,2,2));
        player.addCoord(new Coord(-1,-2,-1));
        Assert.assertEquals(player.getFloor(),1);

        int x = 1;
        int y = 2;

        player.playerMove(x,y, player.getFloor());
        Assert.assertEquals(x,player.getX());
        Assert.assertEquals(y,player.getY());
    }

    /**
     * Testing the player combat
     * Rufus has 2 strength
     * Check if the strength stat becomes 0, afterwards checks if the player is dead.a
     */
    @Test
    public void testCombat(){
        Player player = new Player();
        player.setCharacter(KharacterFactory.createRufus());
        int startStrength = player.getCharacter().getStat(Stat.STRENGTH); //Rufus has 2 strength
        player.getCharacter().updateStatFromCombat(Stat.STRENGTH,2);
        Assert.assertEquals(startStrength-2,player.getCharacter().getStat(Stat.STRENGTH));
        Assert.assertEquals(0,player.getCharacter().getStat(Stat.STRENGTH));
        Assert.assertTrue(player.isPlayerDead());

    }

}

