package modelTest;

import model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class testPlayer {
  
    @Test
    public void testEquippingItem(){
        Player player = new Player();
        Game game = Game.getInstance();
        game.createCharaters();
        player.setCharacter(game.getCharacterList().get(0));
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
        HashMap<Stat, Integer> characterStat = new HashMap<>();
        characterStat.put(Stat.STRENGTH,2);

        player.setCharacter(new Kharacter(characterStat,"TestCharacter"));
        Assert.assertTrue(player.isEventPassed(Stat.STRENGTH,-1));
    }


}

