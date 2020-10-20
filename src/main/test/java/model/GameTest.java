package model;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    /**
     * Testing if game can be initialized
     */
    @Test
    public void canInit(){
        Game game;
        game = Game.getInstance();
        Assert.assertNotNull(game);
    }

    /**
     * Testing if players can be created
     */
    @Test
    public void createPLayersTest(){
        Game game = Game.getInstance();
        int playerAmount = 2;
        game.setPlayerAmount(playerAmount);
        Assert.assertEquals(game.getPlayerList().size(), playerAmount);

    }

    /**
     * Testing if the method "checkAllPlayersHaveChars behaves as it should.
     * Create 2 players, set character on one of them then checkFalse
     * set character on other character,checkTrue
     */
    @Test
    public void testAllPlayersHasCharacter(){
        Game game = Game.getInstance();
        game.createPlayers(2);
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createRufus());
        Assert.assertFalse(game.checkAllPlayersHaveChars());
        game.getPlayerList().get(1).setCharacter(KharacterFactory.createMedera());
        Assert.assertTrue(game.checkAllPlayersHaveChars());
    }
}
