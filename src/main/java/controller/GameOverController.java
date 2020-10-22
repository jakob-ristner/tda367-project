package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;

/**
 * Controller for GameOverView
 * sets all the buttons and handlers
 */

public class GameOverController extends AbstractController {
    Button closeGameButton;


    GameOverController(Game game) {
        super(game);
    }

    void setCloseGameButton(Button closeGameButton) {
        this.closeGameButton = closeGameButton;
        initButton();
    }

    void initButton() {
        closeGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(1);
            }
        });
    }

}
