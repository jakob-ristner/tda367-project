package controller;

import model.Game;
import view.GameView;
import view.ViewInterface;

public class GameController implements GameObserver{
    private Game game;
    private GameView view;
    private ViewInterface characterSelectView;
    private ViewInterface startScreenView;
    private ViewInterface mainGameView;
    private CharacterSelectController characterSelectController;
    private StartScreenController startScreenController;
    private MainGameViewController mainGameViewController;


    public GameController(GameView view, Game game){
        this.view = view;
        this.game = game;
        initViews();
        initControllers();
    }

    private void initViews() {
        startScreenView = view.getStartScreenView();
        characterSelectView = view.getCharacterSelectView();
        mainGameView = view.getMainGameView();
    }

    private void initControllers() {
        startScreenController = new StartScreenController(game, startScreenView);
        startScreenController.setNextView(characterSelectView);
        startScreenController.setIntInput(view.getStartScreenIntInput());
        startScreenController.setConfirmButton(view.getStartScreenConfirmButton());

        characterSelectController = new CharacterSelectController(game, characterSelectView);
        characterSelectController.setButtonMap(view.getCharSelectButtons());
        characterSelectController.setTextList(view.getCharSelectTexts());
        characterSelectController.setNextView(mainGameView);

        mainGameViewController = new MainGameViewController(game, mainGameView);
    }

    @Override
    public void updateCurrentPlayer() {
        view.updateCurrentPlayerIndex(game.getCurrentPlayerIndex());
    }

    @Override
    public void updateMapData() {
        view.updateMainGameViewMapData();
    }

    @Override
    public void initMapData() {
        view.initMapData();
    }

    @Override
    public void updateTurn() {
        //TODO add turn counter maybe?
    }
}