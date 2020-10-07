package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class MoveEventView extends EventView {
    Button moveButton;
    public MoveEventView(Group root, int width, int height) {
        super(root, width, height);
        moveButton = new Button();
        moveButton.setPrefSize(eventText.getPrefWidth(), 50);
        moveButton.setLayoutX(eventText.getLayoutX());
        moveButton.setLayoutY(eventPane.getLayoutY() + 220);
        addNode(moveButton);
    }

    @Override
    public Button getEventButton() {
        return moveButton;
    }

    @Override
    public void viewToFront() {

    }

    @Override
    public void close() {

    }
}
