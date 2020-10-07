package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class ItemEventView extends EventView {
    Button eventButton;

    public ItemEventView(Group root, int width, int height) {
        super(root, width, height);
        eventButton = new Button();
    }

    @Override
    public Button getEventButton() {
        return eventButton;
    }

    @Override
    public void viewToFront() {

    }

    @Override
    public void close() {

    }
}
