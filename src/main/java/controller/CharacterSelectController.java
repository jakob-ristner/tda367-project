package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharacterSelectController {
    private Game game;
    private HashMap<Integer, Button> buttonMap;
    private ViewInterface characterSelectView;
    private ViewInterface nextView;

    public CharacterSelectController(Game game, ViewInterface characterSelectView, HashMap<Integer, Button> buttonMap){
        this.game = game;
        this.characterSelectView = characterSelectView;
        this.buttonMap = buttonMap;
        initButton();
    }

   private void initButton(){
        buttonMap.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(0, buttonMap.get(0));
            }

        });

        buttonMap.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(1, buttonMap.get(1));
            }
        });

        buttonMap.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(2, buttonMap.get(2));
            }
        });

        buttonMap.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(3, buttonMap.get(3));
            }
        });
    }

    private void buttonHandler(int index, Button button){
        game.getCurrentPlayer().setCharacter(game.getCharacterList().get(index));
        game.updateCurrentPlayer();
        deActivateButton(button);
        if (game.checkAllPlayersHaveChars())
            showNextView();
    }


    private void deActivateButton(Button button){
        button.setDisable(true);
    }

    private void showNextView() {
        //nextView.viewToFront();
        System.out.println("next view");
    }

    public void setNextView(ViewInterface nextView) {
        this.nextView = nextView;
    }




}
