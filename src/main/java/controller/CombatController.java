package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

import java.util.List;

public class CombatController extends AbstractController{
    Button combatButton;
    Button exitButton;
    ViewInterface combatView;

    protected CombatController(Game game, ViewInterface combatView) {
        super(game);
        this.combatView = combatView;
    }

    public void setButton(List<Button> buttonList) {
        this.combatButton = buttonList.get(0);
        this.exitButton = buttonList.get(1);
        initButton();
    }

    private void initButton(){
        combatButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.notifyCombat();
                exitButton.setDisable(false);
                combatButton.setDisable(true);

            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showNextView();
                combatButton.setDisable(false);
                exitButton.setDisable(true);
                game.removeDeadPlayersFromGame();
                game.notifyGameData();
            }
        });
    }
}
