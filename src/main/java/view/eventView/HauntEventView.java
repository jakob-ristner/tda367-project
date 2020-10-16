package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class HauntEventView extends EventView {
    Button hauntButton;

    public HauntEventView(Group root, int width, int height) {
        super(root, width, height);
        hauntButton = new Button();
        hauntButton.setPrefSize(eventText.getPrefWidth(), 50);
        hauntButton.setLayoutX(eventText.getLayoutX());
        hauntButton.setLayoutY(eventPane.getLayoutY() + 220);
        hauntButton.setText("Spooky Spooky you are now insane!");
        addNode(hauntButton);
    }


    @Override
    public Button getEventButton() {
        return hauntButton;
    }


}
