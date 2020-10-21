package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;


public class GameOverController extends AbstractController {
    ViewInterface gameOverView;;
    Button closeGameButton;


    GameOverController(Game game) {
        super(game);
    }
    void setCloseGameButton(Button closeGameButton) {
        this.closeGameButton = closeGameButton;

        initButton();
    }

    void initButton(){
        closeGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(1);
            }
        });

    }



}
