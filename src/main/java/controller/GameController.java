package controller;


import model.Game;
import view.GameView;
import view.ViewInterface;

public class GameController implements GameObserver,EventObserver{
    private Game game;
    private GameView view;
    private ViewInterface characterSelectView;
    private ViewInterface startScreenView;
    private ViewInterface mainGameView;
    private CharacterSelectController characterSelectController;
    private StartScreenController startScreenController;
    private MainGameViewController mainGameViewController;
    private EventController eventController;

    public GameController(GameView view, Game game){
        this.view = view;
        this.game = game;
        initViews();
        initControllers();
        initEvent();
    }

    private void initEvent() {
        game.registerEventObserver(this);
    }

    private void initViews() {
        startScreenView = view.getStartScreenView();
        characterSelectView = view.getCharacterSelectView();
        mainGameView = view.getMainGameView();
    }

    private void initControllers() {
        startScreenController = new StartScreenController(game);
        startScreenController.setNextView(characterSelectView);
        startScreenController.setIntInput(view.getStartScreenIntInput());
        startScreenController.setConfirmButton(view.getStartScreenConfirmButton());

        characterSelectController = new CharacterSelectController(game);
        characterSelectController.setStartGameButton(view.getStartGameButton());
        characterSelectController.setButtonMap(view.getCharSelectButtons());
        characterSelectController.setTextList(view.getCharSelectTexts());
        characterSelectController.setNextView(mainGameView);

        mainGameViewController = new MainGameViewController(game);

        eventController = new EventController(game);
        eventController.setEventButtonMap(view.getEventButtons());
        eventController.setStartScreen(startScreenView);
        eventController.setMainGameView(mainGameView);

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
        mainGameViewController.setDoorButtons(view.getMainGameViewDoorButtons());
        mainGameViewController.setEndTurnButton(view.getMainGameViewEndTurnButton());
    }

    @Override
    public void updateTurn() {
        //TODO add turn counter maybe?
    }

    @Override
    public void updateEventEffect() {
        view.updateEventEffect();
    }
    @Override
    public void updateEventView(int eventType, String eventText) {
        view.updateEventView(eventType, eventText);
        view.updateMainGameViewMapData();

    }
}