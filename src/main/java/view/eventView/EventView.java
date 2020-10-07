package view.eventView;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import view.ViewInterface;


public abstract class EventView implements ViewInterface {
    Pane rootPane;
    AnchorPane eventPane;
    TextArea eventText;

    int width;
    int height;


    public EventView(Group root, int width, int height) {
        this.width = width;
        this.height = height;
        rootPane = new Pane();
        rootPane.setPrefSize(width,height);
        rootPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5)");
        root.getChildren().add(rootPane);

        int dwidth = 300;
        int dheight = 300;
        eventPane = new AnchorPane();
        eventPane.setPrefSize(width - dwidth, height - dheight);
        eventPane.setLayoutX(dwidth/2);
        eventPane.setLayoutY(dheight/2);
        eventPane.setStyle("-fx-background-color: white");
        rootPane.getChildren().add(eventPane);

        eventText = new TextArea();
        addNode(eventText);
        eventText.setPrefSize((width -dwidth)/2, (height -dheight)/2);
    }


    public Pane getRootPane() {
        return rootPane;
    }

    public abstract Button getEventButton();

    @Override
    public void addNode(Node node) {
        eventPane.getChildren().add(node);
    }

    @Override
    public void viewToFront(){
        rootPane.toFront();
    }

    public void setRootPane(Pane rootPane) {
        this.rootPane = rootPane;
    }

    public AnchorPane getEventPane() {
        return eventPane;
    }

    public void setEventPane(AnchorPane eventPane) {
        this.eventPane = eventPane;
    }

    public TextArea getEventText() {
        return eventText;
    }

    public void setEventText(TextArea eventText) {
        this.eventText = eventText;
    }


}
