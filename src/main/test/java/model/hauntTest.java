package model;


import controller.GameController;
import javafx.scene.Scene;
import model.Events.RollDiceEvent;
import org.junit.Test;
import view.GameView;

public class hauntTest {

    @Test
    public void combatTest(){
        Game game = Game.getInstance();
        //GameView view = new GameView(game);
        //Scene scene = new Scene(view.getRoot(), GameView.WINDOW_W, GameView.WINDOW_H);
        //GameController gm = new GameController(view,game);
        game.createPlayers(2);

        for (Player p:game.getPlayerList()) {
            p.setCharacter(KharacterFactory.createMedera());
        }

        game.eventTriggered();
        InsanityHauntState gs = (InsanityHauntState)game.getRandomHaunt();
        //gs.init();
        gs.game = game;
        gs.turn(game.getCurrentPlayer());

    }
}
