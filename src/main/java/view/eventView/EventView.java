package view.eventView;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import view.ViewInterface;

import java.util.HashMap;


public abstract class EventView implements ViewInterface {
    Pane rootPane;
    AnchorPane eventPane;
    TextArea eventText;
    Text header;



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
        eventPane.setStyle("-fx-background-color: black; -fx-border-size: 2px; -fx-border-color: white;");
        rootPane.getChildren().add(eventPane);

        eventText = new TextArea();

        eventText.setPrefSize((width -dwidth)/2, (height -dheight)/2);
        eventText.setLayoutX(eventPane.getLayoutX() + dwidth/3);
        eventText.setLayoutY(eventPane.getLayoutY() - 50);
        //eventText.setText("Lorem Ipsum Dolar Sit Amet...");
        eventText.setStyle("-fx-border-color: white; -fx-control-inner-background: black; -fx-background-color: black; -fx-border-size: 2px; -fx-text-fill: white;");
        eventText.setFont(Font.font("Ink Free",20));
        eventText.setWrapText(true);


        eventText.setEditable(false);
        addNode(eventText);

        header = new Text();
        header.setX(eventPane.getPrefWidth()/3);
        header.setY(eventPane.getMinHeight() + 50);
        header.setTextAlignment(TextAlignment.CENTER);
        header.setStyle("-fx-font-size: 20;");
        addNode(header);
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

    public void setEventButtonText(String s){
        getEventButton().setText(s);
    }



    public TextArea getEventText() {
        return eventText;
    }

    public void setEventText(String text) {
        eventText.setText(text);
    }


}
