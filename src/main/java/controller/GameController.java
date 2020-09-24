package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Event;
import model.Game;
import view.GameView;
import view.ViewInterface;

public class GameController {
    private GameView view;
    private Button testButton;

    public GameController(GameView view, Game game){
        this.view = view;
        testButton = new Button();
        testButton.setLayoutX(300);
        testButton.setLayoutY(300);
        testButton.setText("Click me");
        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getView().getTestView().viewToFront();
            }
        });
        view.getTestView().addNode(testButton);
    }

    private GameView getView(){
        return view;
    }


}