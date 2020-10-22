package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class HauntEventView extends EventView {
    Button hauntButton;

    public HauntEventView(Group root, int width, int height) {
        super(root, width, height);
        hauntButton = new Button();
        hauntButton.setPrefSize(eventText.getPrefWidth(), 50);
        hauntButton.setLayoutX(eventText.getLayoutX());
        hauntButton.setLayoutY(eventPane.getLayoutY() + 220);
        hauntButton.setFont(Font.font("Ink Free", 20));

        addNode(hauntButton);
    }


    @Override
    public Button getEventButton() {
        return hauntButton;
    }


}
