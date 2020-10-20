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
        Assert.assertEquals(game.getPlayerList().size(), playerAmount);

    }
    @Test
    public void testAllPlayersHasCharacter(){
        Game game =Game.getInstance();
        game.createPlayers(2);
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createRufus());
        Assert.assertFalse(game.checkAllPlayersHaveChars());
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createMedera());
        Assert.assertTrue(game.checkAllPlayersHaveChars());
    }
}
