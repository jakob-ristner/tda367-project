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

import java.awt.*;
import java.sql.SQLOutput;

public class GameView {
	private Group root;
	private TestView testView;

	public GameView(Game game) {
		root = new Group();
		testView = new TestView(root);

	}


	public void addNode(Node node) {
		root.getChildren().add(node);
	}

	public Group getRoot() {
		return root;
	}

	public ViewInterface getTestView() {
		return testView;
	}
}
