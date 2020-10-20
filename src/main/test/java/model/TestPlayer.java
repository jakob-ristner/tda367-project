package model;

import javafx.scene.control.Spinner;
import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

import java.util.HashMap;

public class TestPlayer {

    /**
     * Testing equipping item. Creating a new player->setCharacter and save the stat of the character.
     * Then createItem->equip it-> compare characterStat+Swordstat with a character equipped with a sword.
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
        Assert.assertTrue(player.getCharacter().getStat(Stat.STRENGTH)== characterStat+sword.getStat(Stat.STRENGTH));


    }

    /**
     * Create new player-> Set a kharacter-> test if a roll between 0<=maxstat(
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
        player.playerMove(1,2);
        Assert.assertEquals(player.getX(),1);
        Assert.assertEquals(player.getY(),2);
    }

    /**
     * Testing the player combat
     * Check if the strength stat becomes 0, afterwards checks if the player is dead.
     */
    @Test
    public void testCombat(){
        Player player = new Player();
        player.setCharacter(KharacterFactory.createRufus());
        int startStrength = player.getCharacter().getStat(Stat.STRENGTH);
        player.getCharacter().updateStatFromCombat(Stat.STRENGTH,2);
        Assert.assertEquals(startStrength-2,player.getCharacter().getStat(Stat.STRENGTH));
        Assert.assertEquals(player.getCharacter().getStat(Stat.STRENGTH),0);
        Assert.assertTrue(player.isPlayerDead());

    }

}

