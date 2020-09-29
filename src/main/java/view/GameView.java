package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.*;

import model.Game;

import javax.swing.text.View;
import java.awt.*;
import java.sql.SQLOutput;

public class GameView {
	public static final int WINDOW_H = 500;
	public static final int WINDOW_W = 500;
	private Group root;
	private CharacterSelectView characterSelectView;
	private StartScreenView startScreenView;

	public GameView(Game game) {
		root = new Group();
		characterSelectView = new CharacterSelectView(game, root, WINDOW_W, WINDOW_H);
		startScreenView = new StartScreenView(game, root, WINDOW_W, WINDOW_H);
		startScreenView.viewToFront();

	}


	public void addNode(Node node) {
		root.getChildren().add(node);
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

	public void updateCurrentPlayerIndex(int index) {
		characterSelectView.setCurrentPlayerText(index);
	}



}
