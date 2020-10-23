package model;

import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

public class InsanityHauntTest {
    /**
     *Testing the haunted players winCondition. If all players is dead, return true.
     */
/*
    @Test
    public void testWinCondition(){
        Game game = Game.getInstance();
        InsanityHauntState insanityHauntState = new InsanityHauntState();

        game.createPlayers(1);
        game.getPlayerList().get(0).setHauntedPlayer();
        Assert.assertTrue(insanityHauntState.winConditionChecker());
    }

 */

    @Test
    public void testCombat(){
        Game game = Game.getInstance();
        game.createPlayers(3);

        InsanityHauntState insanityHauntState = new InsanityHauntState();
        System.out.println(game.getCurrentPlayer());
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createRufus());
        game.getPlayerList().get(1).setCharacter(KharacterFactory.createRufus());
        game.getPlayerList().get(2).setCharacter(KharacterFactory.createRufus());
        //insanityHauntState.init();

        game.getPlayerList().get(0).setPos(new Coord(1,2,2));
        game.getPlayerList().get(1).setPos(new Coord(1,2,2));
        game.getPlayerList().get(2).setPos(new Coord(1,2,2));
       //insanityHauntState.turn(game.getPlayerList().get(3));

    }


}

