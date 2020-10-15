package model;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void canInit(){
        Game game;
        game = Game.getInstance();
        Assert.assertNotNull(game);
    }

    @Test
    public void createPLayersTest(){
        Game game = Game.getInstance();
        int playerAmount = 2;
        game.setPlayerAmount(playerAmount);
        Assert.assertTrue(game.getPlayerList().size() == playerAmount);

    }
}
