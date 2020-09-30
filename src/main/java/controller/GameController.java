package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Event;
import model.Game;
import view.GameView;
import view.ViewInterface;

public class GameController implements GameObserver{
    private GameView view;
    private Game game;
    private ViewInterface characterSelectView;
    private CharacterSelectController characterSelectController;
    private ViewInterface startScreenView;
    private StartScreenController startScreenController;


    public GameController(GameView view, Game game){
        this.view = view;
        this.game = game;
        game.registerObserver(this);
        characterSelectView = view.getCharacterSelectView();
        characterSelectController = new CharacterSelectController(game, characterSelectView);
        startScreenView = view.getStartScreenView();
        startScreenController = new StartScreenController(game, startScreenView);
        startScreenView.setNextView(characterSelectView);
        startScreenView.viewToFront();
    }

    private GameView getView(){
        return view;
    }


    @Override
    public void update() {

    }

    @Override
    public void updateCurrentPlayer() {
        view.updateCurrentPlayerIndex(game.getCurrentPlayerIndex());

    }
}