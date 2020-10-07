package view;


import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import javafx.scene.*;

import model.Game;

import java.util.HashMap;
import java.util.List;

public class GameView {
	public static final int WINDOW_H = 800;
	public static final int WINDOW_W = 1300;
	private Group root;
	private CharacterSelectView characterSelectView;
	private StartScreenView startScreenView;
	private MainGameView mainGameView;

	public GameView(Game game) {
		root = new Group();
		startScreenView = new StartScreenView(root, WINDOW_W, WINDOW_H);
		characterSelectView = new CharacterSelectView(root, WINDOW_W, WINDOW_H);
		characterSelectView.initButton(game.getCharacterNames());
		characterSelectView.initText(game.getCharacterStats());
		mainGameView = new MainGameView(root, WINDOW_W, WINDOW_H, game);
		startScreenView.viewToFront();
	}

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

	public void updateCurrentPlayerIndex(int index) {
		characterSelectView.setCurrentPlayerText(index);
	}

	public void updateMainGameViewMapData() {
		mainGameView.updateMapData();
	}

	public void initMapData() {
		mainGameView.initMapData();
	}


	//View element getters
	public Button getStartScreenConfirmButton() {
		return startScreenView.getButton();
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

}
