package model;


import controller.GameController;
import model.Events.RollDiceEvent;
import org.junit.Test;
import view.GameView;

public class hauntTest {

    @Test
    public void combatTest(){

        Game game = Game.getInstance();

        GameView view = new GameView(game);
        GameController gm = new GameController(view,game);
        game.createPlayers(2);

        for (Player p:game.getPlayerList()) {
            p.setCharacter(KharacterFactory.createMedera());
        }

        game.getBoard().getFloor(1).getTile(0,0).setEvent(new RollDiceEvent(1, 0, 0 , "Ploj", 2,false));
        game.handleEvent();
        game.moveCurrentPlayer(0,0);

    }
}
