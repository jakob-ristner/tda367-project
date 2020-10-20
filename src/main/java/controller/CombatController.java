package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Duration;
import model.Game;
import view.ViewInterface;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
                combatView.addNode(exitButton);
                combatButton.setDisable(true);

            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showNextView();
            }
        });
    }
}
