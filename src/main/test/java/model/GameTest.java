package model;

import model.Events.ItemEvent;
import model.Events.TestEvent;
import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

import java.util.List;

/**
 * GameTest is focused on Game methods, require a dummyObserver for some methods.
 */

public class GameTest {
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

    @Test
    public void testMovePlayer(){
        DummyObserver dummyObserver = new DummyObserver();
        Game game = Game.getInstance();
        game.setObserver(dummyObserver);

        game.setPlayerAmount(1);
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createRufus());
        Coord stairCoord = game.getStairsUpOnCurrentFloor().get(0);


        game.getCurrentPlayer().setPos(new Coord(stairCoord.getX()+1,stairCoord.getY(),stairCoord.getFloor()));
        game.moveCurrentPlayer(-1,0);
        game.moveCurrentPlayer(0,-1);
        Assert.assertEquals(stairCoord.getFloor()+1,game.getCurrentPlayer().getFloor());
    }

    /**
     * Testing if the method "checkAllPlayersHaveChars behaves as it should.
     * Create 2 players, set character on one of them then checkFalse
     * set character on other character,checkTrue
     */
    @Test
    public void testAllPlayersHasCharacter(){
        Game game = Game.getInstance();
        game.setPlayerAmount(2);
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createRufus());
        Assert.assertFalse(game.checkAllPlayersHaveChars());
        game.getPlayerList().get(1).setCharacter(KharacterFactory.createMedera());
        Assert.assertTrue(game.checkAllPlayersHaveChars());
    }


    @Test
    public void testCreateListOfAllPlayersSameCoord(){
        Game game = Game.getInstance();
        game.setPlayerAmount(4);

        for(int i =0; i<game.getPlayerList().size();i++){
            Coord coord =  new Coord(1,2,1);
            game.getPlayerList().get(i).setPos(coord);
        }
        game.getPlayerList().get(3).playerMove(1,1,1);
        List<Player> playersInSameRoom = game.createListOfPlayersInSameRoom();
        Assert.assertEquals(game.getPlayerList().size()-1,playersInSameRoom.size());
    }

    @Test
    public void testHandleEvent(){
        Game game = Game.getInstance();
        game.registerEventObserver(new EventObserver() {
            @Override
            public void updateEventView(int eventType, String eventText) {

            }

            @Override
            public void updateEventEffect() {

            }
        });
        game.setPlayerAmount(1);
        game.getPlayerList().get(0).setCharacter(KharacterFactory.createDebugKhar());
        game.setObserver(new DummyObserver());
        int eventcounter = 0;
        for(int floor = 0; floor < 2; floor++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    //game.updateCurrentPlayer();
                    if (!game.getBoard().tryActivateEventOnPlayerPos(game.getCurrentPlayer())) {
                        game.getCurrentPlayer().setPos(new Coord(i, j, floor));
                        game.updateCurrentPlayer();
                    } else {
                        if(eventcounter == game.getHauntTrigger()){
                            break;
                        }
                        game.updateCurrentPlayer();
                        game.moveCurrentPlayer(0, 0);
                        game.handleEvent();


                    }
                }
            }
        }

        game.endTurn();
        game.moveCurrentPlayer(0,0);
        Assert.assertTrue(game.getCurrentPlayer().isHaunted());
    }

}
