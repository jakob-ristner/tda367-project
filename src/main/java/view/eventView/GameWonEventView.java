package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameWonEventView extends EventView {
    Button gameWonButton;

    public GameWonEventView(Group root, int width, int height) {
        super(root, width, height);
        gameWonButton = new Button();
        gameWonButton.setPrefSize(eventText.getPrefWidth(), 50);
        gameWonButton.setLayoutX(eventText.getLayoutX());
        gameWonButton.setLayoutY(eventPane.getLayoutY() + 220);
        gameWonButton.setFont(Font.font("Ink Free", 20));
        addNode(gameWonButton);


        header.setText("Congratulations adventurers!");
        header.setFont(Font.font("Ink Free", 20));
        header.setFill(Color.WHITE);

    }

    @Override
    public Button getEventButton() {
        return gameWonButton;
    }

}
