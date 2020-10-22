package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * ItemEventView shows a view when a player picks up an item
 * It displays the items attributes etc.
 */

public class ItemEventView extends EventView {
    Button eventButton;

    public ItemEventView(Group root, int width, int height) {
        super(root, width, height);
        eventButton = new Button();
        eventButton.setPrefSize(eventText.getPrefWidth(), 50);
        eventButton.setLayoutX(eventText.getLayoutX());
        eventButton.setLayoutY(eventPane.getLayoutY() + 220);
        eventButton.setFont(Font.font("Ink Free", 20));
        addNode(eventButton);
        header.setText("You've found an item!");
        header.setFont(Font.font("Ink Free", 20));
        header.setFill(Color.WHITE);
    }


    @Override
    public Button getEventButton() {
        return eventButton;
    }


}
