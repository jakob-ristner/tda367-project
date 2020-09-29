package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import model.Game;
import model.Kharacter;

import java.util.ArrayList;
import java.util.List;


public class CharacterSelectView implements ViewInterface{
    private Game game;
    private List<String> characters;
    private Pane pane = new Pane();



    public CharacterSelectView(Game game, Group root, int width, int height){
        this.game = game;
        characters = game.getCharacterNames();
        root.getChildren().add(pane);

        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: green");
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
