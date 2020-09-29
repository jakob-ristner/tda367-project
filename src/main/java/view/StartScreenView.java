package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import model.Game;

public class StartScreenView implements ViewInterface{
    private Game game;
    private Pane pane;


    public StartScreenView(Game game, Group root, int width, int height) {
        pane = new Pane();
        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: white");

        root.getChildren().add(pane);
    }


    @Override
    public void viewToFront() {
        pane.toFront();
    }

    @Override
    public void addNode(Node node) {
        pane.getChildren().add(node);
    }
}
