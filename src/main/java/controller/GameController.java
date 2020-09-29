package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Event;
import model.Game;
import view.GameView;
import view.ViewInterface;

public class GameController {
    private GameView view;
    private ViewInterface characterSelectView;
    private CharacterSelectController characterSelectController;


    public GameController(GameView view, Game game){
        this.view = view;
        characterSelectView = view.getCharacterSelectView();
        characterSelectController = new CharacterSelectController(game,characterSelectView);

    }

    private GameView getView(){
        return view;
    }

    public void openCharacterSelectView(){
        characterSelectView.viewToFront();
    }

    
}