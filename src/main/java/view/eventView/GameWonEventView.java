package view.eventView;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class GameWonEventView extends EventView {
    Button gameWonButton;

    public GameWonEventView(Group root, int width, int height) {
        super(root, width, height);
        gameWonButton = new Button();
        gameWonButton.setPrefSize(eventText.getPrefWidth(), 50);
        gameWonButton.setLayoutX(eventText.getLayoutX());
        gameWonButton.setLayoutY(eventPane.getLayoutY() + 220);
        gameWonButton.setText("Congratz you've won the game!");
        addNode(gameWonButton);


        header.setText("Badabing badabom du har nu haunt");

    }

    @Override
    public Button getEventButton() {
        return gameWonButton;
    }



    @Override
    public void close() {

    }
}
