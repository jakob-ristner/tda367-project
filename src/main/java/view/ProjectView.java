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

public class ProjectView {
	private Group root;
	private Pane pane;

	public ProjectView(Game game) {
		root = new Group();
		this.pane = new Pane();
		pane.setPrefSize(200, 200);
		pane.setStyle("-fx-background-color: black");
		addNode(pane);

		Rectangle rect = new Rectangle(10, 10, Color.RED);
		addNode(rect);
		Button testButton = new Button("Click here");
		testButton.setLayoutY(300);
		testButton.setLayoutY(300);
		testButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				paneFront(pane);
			}
		});
		root.getChildren().add(testButton);

	}


	public void addNode(Node node) {
		root.getChildren().add(node);
	}

	public Group getRoot() {
		return root;
	}

	public void paneFront(Pane pane){
		pane.toFront();
	}



}
