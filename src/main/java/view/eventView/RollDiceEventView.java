package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * RollDiceEventView shows a view prompting the player that they
 * have entered an Rolldice event, It prompts them to roll the dice
 * and depending on the dice roll they might lose or gains stats
 */

public class RollDiceEventView extends EventView {
    Button rollDiceButton;

    public RollDiceEventView(Group root, int width, int height) {
        super(root, width, height);
        rollDiceButton = new Button();
        rollDiceButton.setPrefSize(eventText.getPrefWidth(), 50);
        rollDiceButton.setLayoutX(eventText.getLayoutX());
        rollDiceButton.setLayoutY(eventPane.getLayoutY() + 220);
        rollDiceButton.setFont(Font.font("Ink Free", 20));
        addNode(rollDiceButton);
        header.setText("Watch your back!");
        header.setFont(Font.font("Ink Free", 20));
        header.setFill(Color.WHITE);
    }

    @Override
    public Button getEventButton() {
        return rollDiceButton;
    }


}
