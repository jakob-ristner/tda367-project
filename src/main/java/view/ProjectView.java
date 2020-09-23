package view;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.*;
import model.Game;

import java.awt.*;

public class ProjectView {
	private Group root;

	public ProjectView(Game game) {
		root = new Group();
		Pane pane = new Pane();
		pane.setPrefSize(200, 200);
		pane.setStyle("-fx-background-color: black");
		addNode(pane);

		Rectangle rect = new Rectangle(10, 10, Color.RED);
		addNode(rect);
	}


	public void addNode(Node node) {
		root.getChildren().add(node);
	}

	public Group getRoot() {
		return root;
	}


}
