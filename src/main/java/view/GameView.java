package view;


import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import javafx.scene.*;

import model.Game;
import view.eventView.*;

import java.util.HashMap;
import java.util.List;

public class GameView {
	public static final int WINDOW_H = 800;
	public static final int WINDOW_W = 1300;
	private Group root;
	private CharacterSelectView characterSelectView;
	private StartScreenView startScreenView;
	private MainGameView mainGameView;
	private CombatScreenView combatScreenView;



	private GameOverView gameOverView;

	private EventView gameWonEventView;
	private EventView itemEventView;
	private EventView moveEventView;
	private EventView rollDiceView;
	private EventView hauntEventView;

	private HashMap<String, Button> buttonEventMap;
	private HashMap<Integer, EventView> eventViewMap;
	private Game game;

	public GameView(Game game) {
		root = new Group();
		this.game = game;
		startScreenView = new StartScreenView(root, WINDOW_W, WINDOW_H);
		characterSelectView = new CharacterSelectView(root, WINDOW_W, WINDOW_H);
		characterSelectView.initButton(game.getCharacterNames());
		characterSelectView.initText(game.getCharacterStats());
		mainGameView = new MainGameView(root, WINDOW_W, WINDOW_H, game);
		combatScreenView = new CombatScreenView(root, WINDOW_W, WINDOW_H);
		gameOverView = new GameOverView(root,WINDOW_W,WINDOW_H);

		initEventView();
		buttonEventMap = new HashMap<>();
		initButtonEventMap();

		startScreenView.viewToFront();
	}

	//Init methods for the view
	public void initHauntView(){
		hauntEventView.setEventText(game.getHauntText());
		hauntEventView.viewToFront();

	}

	private void initButtonEventMap(){
		buttonEventMap.put("GameWonEvent", gameWonEventView.getEventButton());
		buttonEventMap.put("ItemEvent", itemEventView.getEventButton());
		buttonEventMap.put("MoveEvent", moveEventView.getEventButton());
		buttonEventMap.put("RollDiceEvent", rollDiceView.getEventButton());
		buttonEventMap.put("HauntEvent",hauntEventView.getEventButton());
	}

	private void initEventView(){
		eventViewMap = new HashMap<>();

		itemEventView = new ItemEventView(root,WINDOW_W,WINDOW_H );
		eventViewMap.put(-1, itemEventView);
		rollDiceView = new RollDiceEventView(root,WINDOW_W,WINDOW_H);
		eventViewMap.put(-2, rollDiceView);
		moveEventView = new MoveEventView(root,WINDOW_W,WINDOW_H);
		eventViewMap.put(-3, moveEventView);
		gameWonEventView = new GameWonEventView(root,WINDOW_W,WINDOW_H);
		eventViewMap.put(-4, gameWonEventView);
		hauntEventView = new HauntEventView(root,WINDOW_W,WINDOW_H);
	}

	public void initMapData() {
		mainGameView.initMapData();
	}

	public void initCombatScreen() {
		combatScreenView.initPlayerCircles(game.getNonHauntedNamesList(), game.getHauntedNamesInSameRoom());
		combatScreenView.setStaminaText(game.getStaminaNameMap(), game.getDamageMap());
		combatScreenView.viewToFront();
	}

	public void initGameOverView(){
		gameOverView.viewToFront();
	}

	//Getters for views
	public Group getRoot() {
		return root;
	}

	public ViewInterface getCharacterSelectView(){
		return characterSelectView;
	}

	public ViewInterface getStartScreenView() {
		return startScreenView;
	}

	public ViewInterface getMainGameView() {
		return mainGameView;
	}

	//View update methods

	public void updateCurrentPlayerIndex(int index) {
		characterSelectView.setPlayerTexts(index, game.getPlayerAmount());
	}

	public void updateMainGameViewMapData() {
		mainGameView.updateMapData();
	}

	public void updateEventEffect(){
		mainGameView.setEventEffectText();
		mainGameView.fadeEventText();
	}

	public void updateEventView(int eventType, String eventText){
		EventView currentEventView = eventViewMap.get(eventType);
		currentEventView.setEventText(eventText);
		currentEventView.setEventButtonText(game.getEventButtonText());
		currentEventView.viewToFront();
	}





	//View element getters
	public Button getStartScreenConfirmButton() {
		return startScreenView.getButton();
	}

	public HashMap<String, Button> getEventButtons(){
		return buttonEventMap;
	}

	public Spinner<Integer> getStartScreenIntInput() {
		return startScreenView.getIntInput();
	}

	public List<Text> getCharSelectTexts(){
		return characterSelectView.getTexts();
	}

	public HashMap<Integer, Button> getCharSelectButtons(){
		return characterSelectView.getButtonMap();
	}
	public Button getStartGameButton(){
		return characterSelectView.getStartButton();
	}

	public HashMap<Integer, Button> getMainGameViewDoorButtons() {
		return mainGameView.getDoorButtons();
	}

	public Button getMainGameViewEndTurnButton() {
		return mainGameView.getEndTurnButton();
	}

	public List<Button> getCombatButton(){
		return combatScreenView.getCombatButton();
	}

	public ViewInterface getCombatView() {
		return combatScreenView;
	}

	public ViewInterface getGameOverView() {
		return gameOverView;
	}

	public Button getCloseGameButton(){
		return gameOverView.getCloseGameButton();
	}
}
