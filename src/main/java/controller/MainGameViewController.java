package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

import java.util.HashMap;

public class MainGameViewController extends AbstractController{
    private HashMap<Integer, Button> buttonMap;
    private Button endTurnButton;

    public MainGameViewController(Game game, ViewInterface view) {
        super(game, view);
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
