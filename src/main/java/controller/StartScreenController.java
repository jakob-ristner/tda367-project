package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import model.Game;
import view.ViewInterface;


public class StartScreenController {
    private Game game;
    private Button confirmButton;
    private Spinner<Integer> intInput;
    private ViewInterface startScreenView;

    public StartScreenController(Game game, ViewInterface startScreenView) {
        this.game = game;
        this.startScreenView = startScreenView;

        confirmButton = new Button();
        confirmButton.setText("Confirm");
        confirmButton.setLayoutX(200);
        confirmButton.setLayoutY(200);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    setGamePlayerAmount(intInput.getValue());
                    nextView();
            }
        });

        intInput = new Spinner<>(1,4,1,1);
        intInput.setLayoutY(150);
        intInput.setLayoutX(150);

        this.startScreenView.addNode(confirmButton);
        this.startScreenView.addNode(intInput);
    }


    private void setGamePlayerAmount(int playerAmount) {
        playerAmount = Math.min(playerAmount, 4);
        playerAmount = Math.max(playerAmount, 0);
        game.setPlayerAmount(playerAmount);
    }

    private void nextView() {
        startScreenView.nextView();
    }

}