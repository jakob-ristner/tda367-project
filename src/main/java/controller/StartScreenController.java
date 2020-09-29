package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import model.Game;
import view.ViewInterface;


public class StartScreenController {
    private Game game;
    private Button confirmButton;
    private TextField intInput;

    public StartScreenController(Game game, ViewInterface startSreenView) {
        this.game = game;

        confirmButton = new Button();
        confirmButton.setText("Confirm");
        confirmButton.setLayoutX(200);
        confirmButton.setLayoutY(200);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (istextFilled())
                    setGamePlayerAmount(Integer.parseInt(intInput.getText()));
            }
        });

        intInput = new TextField();
        intInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    intInput.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        startSreenView.addNode(confirmButton);
        startSreenView.addNode(intInput);
    }


    private void setGamePlayerAmount(int playerAmount) {
        playerAmount = Math.min(playerAmount, 4);
        playerAmount = Math.max(playerAmount, 0);
        game.setPlayerAmount(playerAmount);
    }

    public boolean istextFilled() {
        return confirmButton.getText().equals("");
    }
}