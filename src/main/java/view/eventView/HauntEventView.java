package view.eventView;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HauntEventView extends EventView {
    Button hauntButton;

    public HauntEventView(Group root, int width, int height) {
        super(root, width, height);
        hauntButton = new Button();
        hauntButton.setPrefSize(eventText.getPrefWidth(), 50);
        hauntButton.setLayoutX(eventText.getLayoutX());
        hauntButton.setLayoutY(eventPane.getLayoutY() + 220);
        hauntButton.setText("Congratz you've won the game!");
        addNode(hauntButton);

        header.setText("Badabing badabom du har nu haunt");

    }

    @Override
    public Button getEventButton() {
        return hauntButton;
    }


    @Override
    public void close() {

    }
}
