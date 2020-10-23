package model;

import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

public class InsanityHauntTest {
    /**
     * Checking so that coverage is made when all players and a haunted player(which is random) enters the same room
     * Checking so that no stats are added
     * Can not check if damage is made/if a player dies since it is based on a random element.
     * Also check that no stats is added when players aren't in the same room.
     */
    @Test
    public void testCombat() {

        Game game = Game.getInstance();
        Class<? extends Game> game2 = game.getClass().asSubclass(game.getClass());
        game.setPlayerAmount(3);

        DummyObserver dummyObserver = new DummyObserver();
        game.setObserver(dummyObserver);
        InsanityHauntState insanityHauntState = new InsanityHauntState();


        Kharacter rufus = KharacterFactory.createRufus();
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            game.getPlayerList().get(i).setCharacter(rufus);
            game.getPlayerList().get(i).setPos(new Coord(1, 2, 2));
        }
        insanityHauntState.init();
        insanityHauntState.turn(game.getPlayerList().get(2));

        for (int i = 0; i < game.getPlayerList().size(); i++) {
            Assert.assertEquals(rufus.getStats(), game.getPlayerList().get(i).getCharacter().getStats());
            game.getPlayerList().get(i).playerMove(i, 0, 0);
        }

        insanityHauntState.turn(game.getPlayerList().get(2));
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            Assert.assertEquals(rufus.getStats(), game.getPlayerList().get(i).getCharacter().getStats());

        }
    }

    /**
     * Checking that if all players are killed, the monster wins.
     */
    @Test
    public void testWinCondition() {

        Game game = Game.getInstance();
        InsanityHauntState insanityHauntState = new InsanityHauntState();


        DummyObserver dummyObserver = new DummyObserver();
        game.setObserver(dummyObserver);

        game.setPlayerAmount(2);

        Kharacter kharacter0 = KharacterFactory.createMedera();
        Kharacter kharacter1 = KharacterFactory.createRufus();
        game.getPlayerList().get(0).setCharacter(kharacter0);
        game.getPlayerList().get(1).setCharacter(kharacter1);

        insanityHauntState.init();

        int damageToKharacter0 = game.getPlayerList().get(0).getCharacter().getStat(Stat.STRENGTH);
        int damageToKharacter1 = game.getPlayerList().get(1).getCharacter().getStat(Stat.STRENGTH);

        for (int i = 0; i < game.getPlayerList().size(); i++) {
            Assert.assertFalse(game.getPlayerList().get(i).isPlayerDead());
        }
        game.getPlayerList().get(0).getCharacter().updateStatFromCombat(Stat.STRENGTH, damageToKharacter0);
        game.getPlayerList().get(1).getCharacter().updateStatFromCombat(Stat.STRENGTH, damageToKharacter1);
        game.removeDeadPlayersFromGame();
        Assert.assertTrue(game.getPlayerList().isEmpty());
        Assert.assertTrue(insanityHauntState.winConditionChecker());

    }
    /**
     * Dummyobserver needed for testing
     */

    class DummyObserver implements GameObserver {

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


}

