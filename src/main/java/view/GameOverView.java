package view;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class GameOverView implements ViewInterface {
    private Pane rootPane;
    private Button closeGameButton;


    public GameOverView(Group root, int width, int height) {
        rootPane = new Pane();
        rootPane.setPrefSize(width, height);
        rootPane.setStyle("-fx-background-color: Black");
        root.getChildren().add(rootPane);

        Text winText = new Text();
        winText.setText("The horrors of the house have bested you. Haunted players have won.");
        winText.setWrappingWidth(600);
        winText.setLayoutX(width / 2 - winText.getWrappingWidth() / 2);

        winText.setLayoutY(200);
        winText.setTextAlignment(TextAlignment.CENTER);
        winText.setFont(Font.font("Ink Free", 50));
        winText.setFill(Color.RED);
        addNode(winText);

        closeGameButton = new Button();
        closeGameButton.setPrefSize(width / 8, height / 8);
        closeGameButton.setLayoutX(width / 2 - closeGameButton.getPrefWidth() + 80);
        closeGameButton.setLayoutY(520);
        closeGameButton.setText("Exit Game");
        closeGameButton.setFont(Font.font("Ink Free", 25));
        addNode(closeGameButton);

    }

    public Button getCloseGameButton() {
        return closeGameButton;
    }

    @Override
    public void viewToFront() {
        rootPane.toFront();

    }

    @Override
    public void addNode(Node node) {
        rootPane.getChildren().add(node);

    }

}
