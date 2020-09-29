package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Game;
import model.Kharacter;
import java.util.ArrayList;
import java.util.List;


public class CharacterSelectView implements ViewInterface{
    private Game game;
    private List<String> characters;
    private Pane pane;
    private Text text;
    private Text playerText;
    private ViewInterface nextView;



    public CharacterSelectView(Game game, Group root, int width, int height){

       pane = new Pane();
       text = new Text("Choose your character");
       text.setStyle("-fx-font-size: 40px;");
       text.setWrappingWidth(300);
       text.setTextAlignment(TextAlignment.CENTER);
       text.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
       text.setLayoutY(50);
       addNode(text);

       playerText = new Text();
       playerText.setText("Player 1");
       playerText.setWrappingWidth(300);
       playerText.setTextAlignment(TextAlignment.CENTER);
       playerText.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
       playerText.setLayoutY(150);
       addNode(playerText);



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

    public void setCurrentPlayerText(String str) {
        playerText.setText(str);
    }

    @Override
    public void addNode(Node node) {
        pane.getChildren().add(node);
    }

    @Override
    public void setNextView(ViewInterface view) {
        nextView = view;
    }

    @Override
    public void nextView() {
        nextView.viewToFront();
    }

}
