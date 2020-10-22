package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

import java.util.HashMap;

public class EventController extends AbstractController {
    private HashMap<String, Button> eventButtonMap;
    private ViewInterface mainGameView;

    protected EventController(Game game) {
        super(game);

    }

    void setMainGameView(ViewInterface mainGameView) {
        this.mainGameView = mainGameView;
    }

    void setEventButtonMap(HashMap<String, Button> eventButtonMap) {
        this.eventButtonMap = eventButtonMap;
        initEventButtons();
    }

    private void initEventButtons() {
        eventButtonMap.get("RollDiceEvent").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setNextView(mainGameView);
                game.handleEvent();
                showNextView();

            }
        });

        eventButtonMap.get("ItemEvent").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setNextView(mainGameView);
                game.handleEvent();
                showNextView();

            }
        });

        eventButtonMap.get("MoveEvent").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setNextView(mainGameView);
                game.handleEvent();
                showNextView();

            }
        });

        eventButtonMap.get("GameWonEvent").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        eventButtonMap.get("HauntEvent").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setNextView(mainGameView);
                showNextView();
            }
        });
    }


}
