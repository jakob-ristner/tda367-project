package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TestView implements ViewInterface{
    private Pane pane;
    private Group root;
    public TestView(Group root) {
        this.pane = new Pane();
        this.root = root;
        pane.setPrefSize(200, 200);
        pane.setStyle("-fx-background-color: black");
        root.getChildren().add(pane);

        Rectangle rect = new Rectangle(10, 10, Color.RED);
        root.getChildren().add(rect);



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
