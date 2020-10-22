package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;

import java.util.HashMap;

/**
 * Controller for MainGameView
 * sets all buttons and handlers and sends updates to Game
 */

public class MainGameViewController extends AbstractController {
    private HashMap<Integer, Button> buttonMap;
    private Button endTurnButton;


    protected MainGameViewController(Game game) {
        super(game);

    }

    void setDoorButtons(HashMap<Integer, Button> buttonMap) {
        this.buttonMap = buttonMap;
        buttonMap.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.moveCurrentPlayer(0, -1);
            }
        });
        buttonMap.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.moveCurrentPlayer(1, 0);
            }
        });
        buttonMap.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.moveCurrentPlayer(0, 1);
            }
        });
        buttonMap.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.moveCurrentPlayer(-1, 0);
            }
        });
    }

    void setEndTurnButton(Button endTurnButton) {
        this.endTurnButton = endTurnButton;
        endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.endTurn();
            }
        });
    }

}
