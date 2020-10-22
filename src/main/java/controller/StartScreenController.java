package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import model.Game;


public class StartScreenController extends AbstractController {
    private Button confirmButton;
    private Spinner<Integer> intInput;

    public StartScreenController(Game game) {
        super(game);
    }


    void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
        initButton();
    }

    void setIntInput(Spinner<Integer> intInput) {
        this.intInput = intInput;
    }

    private void initButton() {
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setGamePlayerAmount(intInput.getValue());
                showNextView();
            }
        });
    }


    private void setGamePlayerAmount(int playerAmount) {
        playerAmount = Math.min(playerAmount, 4);
        playerAmount = Math.max(playerAmount, 0);
        game.setPlayerAmount(playerAmount);
    }
}
