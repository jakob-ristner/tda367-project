package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class RollDiceEventView extends EventView{
    Button rollDiceButton;
    public RollDiceEventView(Group root, int width, int height) {
        super(root, width, height);
        rollDiceButton = new Button();
        rollDiceButton.setPrefSize(eventText.getPrefWidth(), 50);
        rollDiceButton.setLayoutX(eventText.getLayoutX());
        rollDiceButton.setLayoutY(eventPane.getLayoutY() + 220);
        addNode(rollDiceButton);
    }

    @Override
    public Button getEventButton() {
        return rollDiceButton;
    }


    @Override
    public void close() {

    }
}
