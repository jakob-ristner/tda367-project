package view;


import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import model.Game;
import view.eventView.*;

import java.util.HashMap;
import java.util.List;

/**
 * GameView sets all the elements for the other view and
 * also inits them. It doesn't itself display anything
 */

public class GameView {
    public static final int WINDOW_H = 800;
    public static final int WINDOW_W = 1300;
    private final Group root;
    private final CharacterSelectView characterSelectView;
    private final StartScreenView startScreenView;
    private final MainGameView mainGameView;
    private final CombatScreenView combatScreenView;


    private final GameOverView gameOverView;

    private EventView gameWonEventView;
    private EventView itemEventView;
    private EventView moveEventView;
    private EventView rollDiceView;
    private EventView hauntEventView;

    private final HashMap<String, Button> buttonEventMap;
    private HashMap<Integer, EventView> eventViewMap;
    private final Game game;

    public GameView(Game game) {
        root = new Group();
        this.game = game;
        startScreenView = new StartScreenView(root, WINDOW_W, WINDOW_H);
        characterSelectView = new CharacterSelectView(root, WINDOW_W, WINDOW_H);
        characterSelectView.initButton(game.getCharacterNames());
        characterSelectView.initText(game.getCharacterStats());
        mainGameView = new MainGameView(root, WINDOW_W, WINDOW_H, game);
        combatScreenView = new CombatScreenView(root, WINDOW_W, WINDOW_H);
        gameOverView = new GameOverView(root, WINDOW_W, WINDOW_H);

        initEventView();
        buttonEventMap = new HashMap<>();
        initButtonEventMap();

        startScreenView.viewToFront();
    }


    private void initButtonEventMap() {
        buttonEventMap.put("GameWonEvent", gameWonEventView.getEventButton());
        buttonEventMap.put("ItemEvent", itemEventView.getEventButton());
        buttonEventMap.put("MoveEvent", moveEventView.getEventButton());
        buttonEventMap.put("RollDiceEvent", rollDiceView.getEventButton());
        buttonEventMap.put("HauntEvent", hauntEventView.getEventButton());
    }

    private void initEventView() {
        eventViewMap = new HashMap<>();

        itemEventView = new ItemEventView(root, WINDOW_W, WINDOW_H);
        eventViewMap.put(-1, itemEventView);
        rollDiceView = new RollDiceEventView(root, WINDOW_W, WINDOW_H);
        eventViewMap.put(-2, rollDiceView);
        moveEventView = new MoveEventView(root, WINDOW_W, WINDOW_H);
        eventViewMap.put(-3, moveEventView);
        gameWonEventView = new GameWonEventView(root, WINDOW_W, WINDOW_H);
        eventViewMap.put(-4, gameWonEventView);
        hauntEventView = new HauntEventView(root, WINDOW_W, WINDOW_H);
    }

    public void initHauntView() {
        hauntEventView.setEventText(game.getHauntText());
        hauntEventView.viewToFront();
        hauntEventView.getEventButton().setText("Accept the role as the haunted one," + " " + game.getCurrentPlayersCharacterName());
    }

    public void initMapData() {
        mainGameView.initMapData();
    }


    public void initCombatScreen() {
        combatScreenView.initPlayerCircles(game.getNonHauntedNamesList(), game.getHauntedNamesInSameRoom());
        combatScreenView.setStaminaText(game.getStaminaNameMap(), game.getDamageMap());
        combatScreenView.viewToFront();
    }

    public void initGameOverView() {
        gameOverView.viewToFront();
    }


    public Group getRoot() {
        return root;
    }

    public ViewInterface getCharacterSelectView() {
        return characterSelectView;
    }

    public ViewInterface getStartScreenView() {
        return startScreenView;
    }

    public ViewInterface getMainGameView() {
        return mainGameView;
    }


    public void updateCurrentPlayerIndex(int index) {
        characterSelectView.setPlayerTexts(index, game.getPlayerAmount());
    }

    public void updateMainGameViewMapData() {
        mainGameView.updateMapData();
    }

    public void updateEventEffect() {
        mainGameView.setEventEffectText();
        mainGameView.fadeEventText();
    }

    public void updateEventView(int eventType, String eventText) {
        EventView currentEventView = eventViewMap.get(eventType);
        currentEventView.setEventText(eventText);
        currentEventView.setEventButtonText(game.getEventButtonText());
        currentEventView.viewToFront();
    }


    public Button getStartScreenConfirmButton() {
        return startScreenView.getButton();
    }

    public HashMap<String, Button> getEventButtons() {
        return buttonEventMap;
    }

    public Spinner<Integer> getStartScreenIntInput() {
        return startScreenView.getIntInput();
    }

    public List<Text> getCharSelectTexts() {
        return characterSelectView.getTexts();
    }

    public HashMap<Integer, Button> getCharSelectButtons() {
        return characterSelectView.getButtonMap();
    }

    public Button getStartGameButton() {
        return characterSelectView.getStartButton();
    }

    public HashMap<Integer, Button> getMainGameViewDoorButtons() {
        return mainGameView.getDoorButtons();
    }

    public Button getMainGameViewEndTurnButton() {
        return mainGameView.getEndTurnButton();
    }

    public List<Button> getCombatButton() {
        return combatScreenView.getCombatButton();
    }

    public ViewInterface getCombatView() {
        return combatScreenView;
    }

    public ViewInterface getGameOverView() {
        return gameOverView;
    }

    public Button getCloseGameButton() {
        return gameOverView.getCloseGameButton();
    }
}
