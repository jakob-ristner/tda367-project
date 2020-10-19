package model;

import javafx.scene.control.Spinner;
import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

import java.util.HashMap;

public class testPlayer {
  
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

    @Test
    public void testRollDice(){

        Player player = new Player();
        Kharacter medera = KharacterFactory.createMedera();
        player.setCharacter(medera);

       Assert.assertTrue(0 <= player.rollStat(Stat.SPEED) && player.rollStat(Stat.SPEED) <= player.getCharacter().getStat(Stat.SPEED));

    }
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

}

