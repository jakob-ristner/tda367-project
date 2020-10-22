package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * MoveEventView shows a view prompting the player that they
 * have entered an move event, It prompts them to roll the dice
 * and depending on the dice roll the event will have different outcomes
 */

public class MoveEventView extends EventView {
    Button moveButton;

    public MoveEventView(Group root, int width, int height) {
        super(root, width, height);
        moveButton = new Button();
        moveButton.setPrefSize(eventText.getPrefWidth(), 50);
        moveButton.setLayoutX(eventText.getLayoutX());
        moveButton.setLayoutY(eventPane.getLayoutY() + 220);
        moveButton.setFont(Font.font("Ink Free", 20));
        addNode(moveButton);
        header.setText("You have encountered a problem");
        header.setFont(Font.font("Ink Free", 20));
        header.setFill(Color.WHITE);

    }

    @Override
    public Button getEventButton() {
        return moveButton;
    }


}
