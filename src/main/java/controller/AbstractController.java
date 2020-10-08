package controller;

import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

public abstract class AbstractController {
    protected Game game;
    protected ViewInterface view;
    private ViewInterface nextView;

    protected AbstractController(Game game, ViewInterface view) {
        this.game = game;
        this.view = view;
    }

    public void showNextView() {
        nextView.viewToFront();
    }

    public void setNextView(ViewInterface nextView) {
        this.nextView = nextView;
    }

}
