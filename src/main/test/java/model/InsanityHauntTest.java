package model;

import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

public class InsanityHauntTest {
    /**
     *Testing the haunted players winCondition. If all players is dead, return true.
     */

    @Test
    public void testWinCondition(){
        Game game = Game.getInstance();
        InsanityHauntState insanityHauntState = new InsanityHauntState();
        class DummyObserver implements GameObserver{

            @Override
            public void updateCurrentPlayer() {

            }

            @Override
            public void updateMapData() {

            }

            @Override
            public void initMapData() {

            }

            @Override
            public void initHauntView() {

            }

            @Override
            public void initCombatScreen() {

            }

            @Override
            public void initGameOverView() {

            }
        }
        DummyObserver dummyObserver = new DummyObserver();
        game.setObserver(dummyObserver);
        insanityHauntState.init();

        game.createPlayers(2);

        Kharacter kharacter0 = KharacterFactory.createMedera();
        Kharacter kharacter1 = KharacterFactory.createRufus();

        game.getPlayerList().get(0).setCharacter(kharacter0);
        game.getPlayerList().get(1).setCharacter(kharacter1);

        int kharakterStat0 = game.getPlayerList().get(0).getCharacter().getStat(Stat.STRENGTH);
        int kharakterStat1 = game.getPlayerList().get(1).getCharacter().getStat(Stat.STRENGTH);

        for(int i = 0; i<game.getPlayerList().size();i++){
            Assert.assertFalse(game.getPlayerList().get(i).isPlayerDead());
        }
        game.getPlayerList().get(0).getCharacter().updateStatFromCombat(Stat.STRENGTH,kharakterStat0);
        game.getPlayerList().get(1).getCharacter().updateStatFromCombat(Stat.STRENGTH,kharakterStat1);
        game.removeDeadPlayersFromGame();
        Assert.assertEquals(game.getPlayerList().size(),0);
        Assert.assertTrue(insanityHauntState.winConditionChecker());




    }



    @Test
    public void testCombatInSameTile(){
        Game game = Game.getInstance();
        game.createPlayers(3);
        class DummyObserver implements GameObserver{

            @Override
            public void updateCurrentPlayer() {

            }

            @Override
            public void updateMapData() {

            }

            @Override
            public void initMapData() {

            }

            @Override
            public void initHauntView() {

            }

            @Override
            public void initCombatScreen() {

            }

            @Override
            public void initGameOverView() {

            }
        }
        DummyObserver dummyObserver = new DummyObserver();
        game.setObserver(dummyObserver);

        InsanityHauntState insanityHauntState = new InsanityHauntState();
        System.out.println(game.getCurrentPlayer());
        Kharacter rufus = KharacterFactory.createRufus();
        for(int i = 0; i< game.getPlayerList().size(); i++){
            game.getPlayerList().get(i).setCharacter(rufus);
            game.getPlayerList().get(i).setPos(new Coord(1,2,2));
        }
        insanityHauntState.init();
        insanityHauntState.turn(game.getPlayerList().get(2));

        /**
         * Checking so that no stats are added after combat
         */
        for(int i = 0; i<game.getPlayerList().size(); i++){
            Assert.assertEquals(game.getPlayerList().get(i).getCharacter().getStats(),rufus.getStats());
            game.getPlayerList().get(i).playerMove(i,0,0);
        }
        /**
         * Checking the same thing when players are not in the same room
         */
        insanityHauntState.turn(game.getPlayerList().get(2));
        for(int i = 0; i<game.getPlayerList().size();i++){
            Assert.assertEquals(game.getPlayerList().get(i).getCharacter().getStats(),rufus.getStats());

        }


    }

}

