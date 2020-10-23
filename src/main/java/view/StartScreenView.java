package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * StartScreenView displays the startScreen prompting players to
 * set amount of players
 */

public class StartScreenView implements ViewInterface {
    private final Pane pane;
    private final Button confirmButton;
    private final Spinner<Integer> intInput;

    public StartScreenView(Group root, int width, int height) {
        pane = new Pane();
        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: black");
        root.getChildren().add(pane);

        confirmButton = new Button();
        confirmButton.setText("Confirm");
        confirmButton.setFont(Font.font("Ink Free", 30));
        confirmButton.setPrefSize(180, 100);
        confirmButton.setLayoutX(width / 2 + confirmButton.getWidth() / 2);
        confirmButton.setLayoutY(height / 2);

        intInput = new Spinner<>(1, 4, 1, 1);
        intInput.setLayoutX(confirmButton.getLayoutX() - 200);
        intInput.setLayoutY(height / 2);
        intInput.setPrefSize(180, 100);
        intInput.setStyle("-fx-font-family: 'Ink Free'; -fx-font-size: 20pt");

        Text titleText = new Text("Welcome to Gastuen.\n How many players will explore the house?");
        titleText.setFont(Font.font("Ink Free", 50));
        titleText.setFill(Color.WHITE);
        titleText.setWrappingWidth(width);
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setLayoutX(0);
        titleText.setLayoutY(100);

        addNode(confirmButton);
        addNode(intInput);
        addNode(titleText);
    }


    @Override
    public void viewToFront() {
        pane.toFront();
    }

    @Override
    public void addNode(Node node) {
        pane.getChildren().add(node);
    }


    public Button getButton() {
        return confirmButton;
    }

    public Spinner<Integer> getIntInput() {
        return intInput;
    }
}